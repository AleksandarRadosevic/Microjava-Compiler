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

	
	public void visit(ConstDeclc constVar) {
		// mozda proveriti da li je dva puta definisana konstanta
		System.out.println(constVar.getType().struct.getKind());
		Tab.insert(Obj.Con, constVar.getName(), constVar.getType().struct);
	}
	
	
	public void visit(VarDeclc varDecl) {
		varDeclCount++;
		System.out.println(varDecl.getType().struct.getKind());
		Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), varDecl.getType().struct);
	}

	public void visit(VarDeclGlobalc varDeclGlobal) {
		varDeclGlobalCount++;
		System.out.println("Globalna promenljiva "+ varDeclGlobal.getVarName()+ " prepoznata" );
		Obj varNode = Tab.insert(Obj.Var, varDeclGlobal.getVarName(), varDeclGlobal.getType().struct);
	}

	public void visit(PrintStmt print) {
		printCallCount++;
	}

	public void visit(ProgNamec progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(Programc program) {
		// add local symbols in program scope
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
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

	public void visit(MethodTypeNamec methodTypeName) {
		this.currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethodName(),methodTypeName.getType().struct);
		methodTypeName.obj = currentMethod;
    	Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethodName(), methodTypeName);
	}
	
    public void visit(MethodDeclc methodDecl){
    	Tab.chainLocalSymbols(this.currentMethod);
    	Tab.closeScope();
    	
    	currentMethod = null;
    }
    
    public void visit(Designatorc designator) {
    	Obj obj = Tab.find(designator.getDesignatorName().getName());
    	if(obj == Tab.noObj){
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getDesignatorName().getName()+" nije deklarisano! ", null);
    	}
    	designator.obj = obj;
    }
    
    
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
		methodTypeName.obj = currentMethod;
    	Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethodName(), methodTypeName);
	}
}

