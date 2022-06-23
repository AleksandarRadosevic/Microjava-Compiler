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
	//Struct currentType;
	Logger log = Logger.getLogger(getClass());

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

	
	//definisanje konstansti
	public void visit(ConstDeclc constVar) {
		// mozda proveriti da li je dva puta definisana konstanta
		Obj obj = Tab.find(constVar.getName());
		if (obj!=Tab.noObj) {
			report_error("Globalna konstanta moze biti definisana jednom", constVar);
		}
		else {
			if (constType.assignableTo(constVar.getType().struct) || constType.getKind()==constVar.getType().struct.getKind()) {
				Tab.insert(Obj.Con, constVar.getName(), constVar.getType().struct);
			}
			else report_error("Konstanti mora biti dodeljen isti tip", constVar);
		}
	}
	
	
	public void visit(ConstInt intVal) {
		constType=Tab.intType;
		
	}
	
	public void visit(ConstChar intVal) {
		constType=Tab.charType;

	}
	
	public void visit(ConstBool intVal) {
		constType=new Struct(Struct.Bool);
	}
	
	//definisanje promenljivih
	public void visit(VarDeclc varDecl) {
		varDeclCount++;
		Obj obj = Tab.currentScope.findSymbol(varDecl.getVarName());
		
		if (obj!=Tab.noObj && obj!=null) {
			//System.out.println("Scope za "+varDecl.getVarName()+" je "+obj.getLevel());
			System.out.println("Ime lokalne promenljive ne sme biti deklarisano vise puta unutar istog opsega");
		}
		else {
			Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), varDecl.getType().struct);
			//System.out.println("Scope za "+varDecl.getVarName()+" je "+varNode.getLevel());
		}
	}
	//parametri u funkciji
	public void visit(Parsc formPar) {
		if (this.currentMethod.getName().equals("main")) {
			System.out.println("Main ne sme imati parametre");
			return ;
		}
		//System.out.println("Lokalni parametar je ");
		//System.out.println(formPar.getName());
		
		Obj varNode = Tab.insert(Obj.Var, formPar.getName(), formPar.getType().struct);
	}
	
	// definisanje globalnih promenljiva 
	public void visit(VarDeclGlobalc varDeclGlobal) {
		varDeclGlobalCount++;
		Obj obj = Tab.currentScope.findSymbol(varDeclGlobal.getVarName());
		if (obj!=Tab.noObj && obj!=null) {
			System.out.println("Ime globalne promenljive ne sme biti deklarisano vise puta unutar istog opsega");
		}
		else {
			Obj varNode = Tab.insert(Obj.Var, varDeclGlobal.getVarName(), varDeclGlobal.getType().struct);
		}
	}

	
	public void visit(PrintStmt print) {
		printCallCount++;
	}

	//definisanje imena programa
	public void visit(ProgNamec progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	//zatvaranje programa
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
			System.out.println("Promenljiva nije deklarisana ");
			return ;
		}
		//System.out.println("Uspesna detekcija pristupu elemanta niza");
		//uspeh
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
		//designatorAssign.getDesignator().obj.getType()
	}
}

