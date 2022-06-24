package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {
	
	int printCallCount = 0;
	int varDeclCount = 0;
	int varDeclGlobalCount = 0;
	Obj currentMethod = null;
	boolean mainExists = false;
	Struct constType = null; 
	
	boolean hasReturn = false;
	
	// used for checking if break appears
	boolean breakLoop;
	int breakLoopLine;
	
	// used for checking if continue appears
	boolean continueLoop;
	int continueLoopLine;
	
	boolean isArray = false;
	
	
	
	//Struct currentType;
	Logger log = Logger.getLogger(getClass());
	
	// report messages start
	//--------------------------------------
	
	public void report_error(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}
	//---------------------------------------------
	// report messages end
	
	
	
	// var declarations start 
	// --------------------------------
	
	public void visit(ConstDeclc constVar) {
		// mozda proveriti da li je dva puta definisana konstanta
		Obj obj = Tab.find(constVar.getName());
		if (obj!=Tab.noObj) {
			report_error("Globalna konstanta moze biti definisana jednom", constVar);
		}
		else {
			if (constType.getKind()==constVar.getType().struct.getKind()) {
				Tab.insert(Obj.Con, constVar.getName(), constVar.getType().struct);
			}
			else report_error("Konstanti mora biti dodeljen isti tip", constVar);
		}
	}
	
	
	public void visit(ConstInt intVal) {
		constType=new Struct(Struct.Int);	
	}
	
	public void visit(ConstChar intVal) {
		constType=new Struct(Struct.Char);
	}
	
	public void visit(ConstBool intVal) {
		constType=new Struct(Struct.Bool);
	}
	
	
	public void visit(VarDeclc varDecl) {
		varDeclCount++;
		Obj obj = Tab.currentScope.findSymbol(varDecl.getVarName());
		
		if (obj!=Tab.noObj && obj!=null) {
			report_error("Ime lokalne promenljive ne sme biti deklarisano vise puta unutar istog opsega", varDecl);
		}
		else {
			Struct str;
			if (isArray) {
				str = new Struct(Struct.Array, varDecl.getType().struct);
				isArray = false;
			}
			else str = varDecl.getType().struct;
			Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), str);
		}
	}
	
	// arguments in function
	public void visit(Parsc formPar) {
		if (this.currentMethod.getName().equals("main")) {
			System.out.println("Main ne sme imati parametre");
			return ;
		}
		//System.out.println("Lokalni parametar je ");
		//System.out.println(formPar.getName());
		
		Obj varNode = Tab.insert(Obj.Var, formPar.getName(), formPar.getType().struct);
	}
	
	
	// global var
	public void visit(VarDeclGlobalc varDeclGlobal) {
		varDeclGlobalCount++;
		Obj obj = Tab.currentScope.findSymbol(varDeclGlobal.getVarName());
		if (obj!=Tab.noObj && obj!=null) {
			report_error("Ime globalne promenljive ne sme biti deklarisano vise puta unutar istog opsega",varDeclGlobal);
		}
		else {
			Struct str;
			if (isArray) {
				str = new Struct(Struct.Array, varDeclGlobal.getType().struct);
				isArray = false;
			}
			else str = varDeclGlobal.getType().struct;
			Obj varNode = Tab.insert(Obj.Var, varDeclGlobal.getVarName(), str);
			
		}
	}
	//----------------------------------------
	
	public void visit(OptionalBracesc op) {
		isArray = true;
	}
	
	
	
	// var declarations end
	
	
	public void visit(PrintStmt print) {
		printCallCount++;
	}

	//definisanje imena programa
	public void visit(ProgNamec progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	//
	public void visit(Programc program) {
		// add local symbols in program scope
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		if (!mainExists) {
			System.out.println("Mora postojati metoda sa imenom main");
		}
	}

	public void visit(Typec type) {
		Obj obj = Tab.find(type.getTypeName());
		if (obj == Tab.noObj) {
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
    		type.struct = Tab.noType;
		} else {
			// da li je dohvacen ulaz u mapi == Typec
			if (Obj.Type == obj.getKind()) {
				// dodela odgovarajuceg tipa 
				type.struct = obj.getType();
				//currentType=type.struct;
			}
			else {
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
    			type.struct = Tab.noType;
			}
		}

	}
	
	// definisanje metoda
	public void visit(MethodTypeNamec methodTypeName) {
		
		this.currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethodName(),methodTypeName.getType().struct);
		methodTypeName.obj = currentMethod;
		
		//System.out.println("Otvoren scoope za fju "+methodTypeName.getMethodName());
    	Tab.openScope();
		//report_info("Obradjuje se funkcija " + methodTypeName.getMethodName(), methodTypeName);
	}
	
	// zavrseno definisanje metoda
    public void visit(MethodDeclc methodDecl){
    	if (currentMethod.getType()!=Tab.noType && !hasReturn) {
    		report_error("Metoda mora imati povratnu vrednost", methodDecl);
    	}
    	Tab.chainLocalSymbols(this.currentMethod);
    	Tab.closeScope();
    	currentMethod = null;
    	hasReturn = false;
    }
    
    
    public void visit(ArrayElem arrayElem) {
		Obj obj = Tab.find(arrayElem.getDesignatorName().getName());
		if (obj==Tab.noObj || obj==null) {
			report_error("Promenljiva nije deklarisana", arrayElem);
			return ;
		}
		if (arrayElem.obj==null)
			arrayElem.obj = new Obj(Obj.Elem, arrayElem.getDesignatorName().getName(),obj.getType().getElemType());
    }
    
    public void visit(Designatorc designator) {
    	Obj obj = Tab.find(designator.getDesignatorName().getName());
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getDesignatorName().getName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    }
    
    // poziv funkcije
    public void visit(FuncCall funcCall ) {
    	Obj func = funcCall.getDesignator().obj;
    	if(Obj.Meth == func.getKind()){
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
    	}else{
			report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
			funcCall.struct = Tab.noType;
    	}
    }
    
	public void visit(VoidFunc methodTypeName) {
		this.currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethodName(),Tab.noType);
		if (methodTypeName.getMethodName().equals("main"))
			mainExists=true;
		methodTypeName.obj = currentMethod;
    	Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethodName(), methodTypeName);
	}
	
	public void visit(RecordDeclc record) {
		
	}
	
	public void visit(ReturnStmt returnStmt) {
		hasReturn = true;
	}
	
	public void visit(DesignatorAssign designatorAssign) {
		if (designatorAssign.getDesignator().obj.getKind()==Obj.Meth) {
			report_error("Nemoguce dodeliti pozivu metode vrednost", designatorAssign);
			return ;
		}
//		if (designatorAssign.getExpr().struct.getKind()==designatorAssign.getDesignator().obj.getType().getKind()) {
//			report_error("Tipovi su nekompatibilni", designatorAssign);
//		}
	}
	
	//inkrementiranje vrednosti
	public void visit(DesignatorIncrement designatorIncrement) {
		if (designatorIncrement.getDesignator().obj.getKind()==Obj.Meth) {
			report_error("Nemoguce inkrementirati poziv metode", designatorIncrement);
		}
//		if (!designatorIncrement.getDesignator().obj.getType().equals(Tab.intType)) {
//			report_error("Nemoguce inkrementirati promenljivu koja nije ceo broj", designatorIncrement);
//		}
	}
	
	// dekrementiranje vrednosti
	public void visit(DesignatorDecrement designatorDec) {
		if (designatorDec.getDesignator().obj.getKind()==Obj.Meth) {
			report_error("Nemoguce dekrementirati poziv metode", designatorDec);
		}
//		if (!designatorDec.getDesignator().obj.getType().equals(Tab.intType)) {
//			report_error("Nemoguce dekrementirati promenljivu koja nije ceo broj", designatorDec);
//		}
	}
	
	public void visit(DesignatorMethod desMethod) {
		if (Obj.Meth!=desMethod.getDesignator().obj.getKind()) {	
			report_error("Greska u pozivu metode", desMethod);
		}
	}
	
	public void visit(DoWhileStmt whileStmt) {
		// check break start 
		
		if (breakLoop && breakLoopLine>whileStmt.getLine() && breakLoopLine<whileStmt.getCondition().getLine()+whileStmt.getLine()) {
			breakLoop = false;
			report_info("Gotovo izvrsavanje petlje", whileStmt);
			//return;
			//System.out.println("Gotovo izvrsavanje petlje pronadjen break na liniji "+breakLoopLine);
		}
		else if (breakLoop) {
			report_error("Break iskaz se poziva samo unutar do while petlje", whileStmt);
			breakLoop = false;
		}
		
		// check break end
		
		// check continue start
		if (continueLoop && continueLoopLine>whileStmt.getLine() && continueLoopLine<whileStmt.getCondition().getLine()+whileStmt.getLine()) {
			continueLoop = false;
			report_info("Nailazak na continue unutar petlje", whileStmt);
		}
		else if (continueLoop) {
			report_error("Continue iskaz se mora nalaziti unutar do while petlje", whileStmt);
			continueLoop = false;
		}
		
		// check continue end
		
	}
	
	public void visit(BreakStmt breakStmt) {
		breakLoop = true;
		breakLoopLine = breakStmt.getParent().getLine();
		
	}
	public void visit(ContinueStmt contStmt) {
		continueLoop = true;
		continueLoopLine = contStmt.getParent().getLine();
	}
	
	public void visit(ReadStmt readStmt) {
		if (!(readStmt.getDesignator().obj.getKind()==Obj.Elem || 
				readStmt.getDesignator().obj.getKind()==Obj.Var || readStmt.getDesignator().obj.getKind()==Obj.Fld)) {
			report_error("Polje u okviru read iskaza mora biti element niza ili promenljiva ili polje klase", readStmt);
			return;
		}
		if (!(readStmt.getDesignator().obj.getType().getKind()==Struct.Int || 
				readStmt.getDesignator().obj.getType().getKind()==Struct.Bool || 
				readStmt.getDesignator().obj.getType().getKind()==Struct.Char)) {
			report_error("Greska mogu se citati promenljive elementi niza ili polja u klasi", readStmt);
			return;
		}
		
	}
	
	
}

