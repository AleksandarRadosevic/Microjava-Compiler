package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	Typec currentType = null;

	boolean hasReturn = false;
	public int nVars=0;
		
	Obj calledFunction = null;
	Map<String, List<Obj>> methodsArguments = new HashMap<String, List<Obj>>();
	int formalArgumentsCounter = 0;

	// used for checking if break appears
	boolean breakLoop;
	int breakLoopLine;

	// used for checking if continue appears
	boolean continueLoop;
	int continueLoopLine;

	boolean isArray = false;
	public static Struct boolStruct = new Struct(Struct.Bool);

	Logger log = Logger.getLogger(getClass());
	
	public boolean errorDetected = false;
	
	public SemanticPass() {
		// add obj e in chr
		Obj e = new Obj(Obj.Var, "e", Tab.intType);
		List<Obj> list = new ArrayList<>();
		list.add(e);
		methodsArguments.put("chr",list);
		Obj c = new Obj(Obj.Var,"c",Tab.charType);
		list = new ArrayList<>();
		list.add(c);
		methodsArguments.put("ord", list);
		Obj a = new Obj(Obj.Var, "a", new Struct(Struct.Array));
		list = new ArrayList<>();
		list.add(a);
		methodsArguments.put("len", list);

	}
	
	
	
	// report messages start
	// --------------------------------------

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
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
	// ---------------------------------------------
	// report messages end

	// var declarations start
	// --------------------------------

	public void visit(ConstDeclc constVar) {
		// mozda proveriti da li je dva puta definisana konstanta
		Obj obj = Tab.find(constVar.getName());
		if (obj != Tab.noObj) {
			report_error("Globalna konstanta moze biti definisana jednom", constVar);
		} else {
			if (constType.getKind() == constVar.getType().struct.getKind()) {
				Tab.insert(Obj.Con, constVar.getName(), constVar.getType().struct);
			} else
				report_error("Konstanti mora biti dodeljen isti tip", constVar);
		}
	}

	public void visit(ConstInt intVal) {
		constType = Tab.intType;
	}

	public void visit(ConstChar intVal) {
		constType = Tab.charType;
	}

	public void visit(ConstBool intVal) {
		constType = boolStruct;
	}

	public void visit(VarDeclc varDecl) {
		varDeclCount++;
		Obj obj = Tab.currentScope.findSymbol(varDecl.getVarName());

		if (obj != Tab.noObj && obj != null) {
			report_error("Ime lokalne promenljive ne sme biti deklarisano vise puta unutar istog opsega", varDecl);
			return;
		} else {
			Struct str;
			if (isArray) {
				str = new Struct(Struct.Array, varDecl.getType().struct);
				isArray = false;
			} else
				str = varDecl.getType().struct;
			Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), str);
			
			
		}
	}

	// arguments in function
	public void visit(Parsc formPar) {
		if (this.currentMethod.getName().equals("main")) {
			System.out.println("Main ne sme imati parametre");
			return;
		}
		Obj varNode = Tab.insert(Obj.Var, formPar.getName(), formPar.getType().struct);

		ArrayList<Obj> arrList = new ArrayList<Obj>();
		if (methodsArguments.containsKey(currentMethod.getName())) {
			arrList = (ArrayList<Obj>) methodsArguments.get(currentMethod.getName());

		}
		arrList.add(varNode);
		methodsArguments.put(currentMethod.getName(), arrList);

	}

	// global var
	public void visit(VarDeclGlobalc varDeclGlobal) {
		varDeclGlobalCount++;
		Obj obj = Tab.currentScope.findSymbol(varDeclGlobal.getVarName());
		if (obj != Tab.noObj && obj != null) {
			report_error("Ime globalne promenljive ne sme biti deklarisano vise puta unutar istog opsega",
					varDeclGlobal);
		} else {
			Struct str;
			if (isArray) {
				str = new Struct(Struct.Array, varDeclGlobal.getType().struct);
				isArray = false;
			} else
				str = varDeclGlobal.getType().struct;
			Obj varNode = Tab.insert(Obj.Var, varDeclGlobal.getVarName(), str);

		}
	}
	// ----------------------------------------

	public void visit(OptionalBracesc op) {
		isArray = true;
	}

	// var declarations end

	public void visit(PrintStmt print) {
		printCallCount++;
	}

	// definisanje imena programa
	public void visit(ProgNamec progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	//
	public void visit(Programc program) {
		// add local symbols in program scope
		nVars = Tab.currentScope().getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		if (!mainExists) {
			System.out.println("Mora postojati metoda sa imenom main");
		}
	}

	public void visit(Typec type) {
		currentType = type;
		Obj obj = Tab.find(type.getTypeName());
		if (obj == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
			type.struct = Tab.noType;
		} else {
			// da li je dohvacen ulaz u mapi == Typec
			if (Obj.Type == obj.getKind()) {
				// dodela odgovarajuceg tipa
				type.struct = obj.getType();
			} else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
				type.struct = Tab.noType;
			}
		}

	}

	// definisanje metoda
	public void visit(MethodTypeNamec methodTypeName) {

		this.currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethodName(), methodTypeName.getType().struct);
		methodTypeName.obj = currentMethod;
		Tab.openScope();
	}

	// zavrseno definisanje metoda
	public void visit(MethodDeclc methodDecl) {
		if (currentMethod.getType() != Tab.noType && !hasReturn) {
			report_error("Metoda mora imati povratnu vrednost", methodDecl);
		}
		Tab.chainLocalSymbols(this.currentMethod);
		Tab.closeScope();
		currentMethod = null;
		hasReturn = false;
	}

	public void visit(ArrayElem arrayElem) {
		Obj obj = Tab.find(arrayElem.getDesignatorNameArr().getName());
		if (obj == Tab.noObj || obj == null) {
			report_error("Promenljiva nije deklarisana", arrayElem);
			return;
		}

		else if (obj.getType().getKind() != Struct.Array) {
			report_error("Promenljiva nije niz", arrayElem);
			return;
		}
		if (arrayElem.obj == null)
			arrayElem.obj = new Obj(Obj.Elem, arrayElem.getDesignatorNameArr().getName(), obj.getType().getElemType());
		if (arrayElem.getExpr().struct != Tab.intType) {
			report_error("Greska u okviru pristupa elementu niza", arrayElem);
		}

	}
	public void visit(DesignatorNameArr arrayElem) {
		Obj obj = Tab.find(arrayElem.getName());
		if (obj == Tab.noObj || obj == null) {
			report_error("Promenljiva nije deklarisana", arrayElem);
			return;
		}
		arrayElem.obj = obj;
	}
		
	
	public void visit(DesignatorName arrayElem) {
		Obj obj = Tab.find(arrayElem.getName());
		if (obj == Tab.noObj || obj == null) {
			report_error("Promenljiva nije deklarisana", arrayElem);
			return;
		}
		arrayElem.obj = obj;
	}
	
	

	public void visit(Designatorc designator) {
		Obj obj = Tab.find(designator.getDesignatorName().getName());
		if (obj == Tab.noObj) {
			report_error("Greska na liniji " + designator.getLine() + " : ime "
					+ designator.getDesignatorName().getName() + " nije deklarisano! ", null);
		}
		designator.obj = obj;
	}

	// function call
	public void visit(FuncCall funcCall) {

		Obj func = funcCall.getDesignatorCalled().getDesignator().obj;
		if (Obj.Meth == func.getKind()) {
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
		} else {
			report_error("Greska na liniji " + funcCall.getLine() + " : ime " + func.getName() + " nije funkcija!",
					null);
			funcCall.struct = Tab.noType;
		}
	}

	public void visit(DesignatorCalled called) {
		calledFunction = called.getDesignator().obj;
	}

	// calling with arguments
	public void visit(ActParsc pars) {
		calledFunction = null;
		formalArgumentsCounter = 0;
	}

	public void visit(ExprPar expr) {
		
		expr.struct = expr.getExpr().struct;		
		
		if (calledFunction != null) {
			ArrayList<Obj> list = (ArrayList<Obj>) methodsArguments.get(calledFunction.getName());
			if (list == null) {
				report_error("Deklarisana funkcija je bez argumenata", expr);
				return;
			}
			try {
				Obj obj = list.get(formalArgumentsCounter);
				if (obj.getType().getKind() != expr.struct.getKind()) {
					report_error("Argumenti deklarisane funkcije se moraju slagati po tipu", expr);
					return;
				} else {
					formalArgumentsCounter++;
				}

			} catch (Exception e) {
				report_error("Deklarisana funkcija nema ovoliko argumenata", expr);
				return;
			}

		}
	}

	public void visit(VoidFunc methodTypeName) {
		this.currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethodName(), Tab.noType);
		if (methodTypeName.getMethodName().equals("main"))
			mainExists = true;
		methodTypeName.obj = currentMethod;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethodName(), methodTypeName);
	}

	public void visit(RecordDeclc record) {
		Tab.chainLocalSymbols(record.getRecordName().obj);
		Tab.closeScope();
	}

	public void visit(RecordName recordName) {
		Obj obj = Tab.find(recordName.getName());
		Struct str = new Struct(Struct.Class);
		if (obj == Tab.noObj) {
			recordName.obj = Tab.insert(Obj.Type, recordName.getName(), str);
			Tab.openScope();
		}
	}

	public void visit(ReturnStmt returnStmt) {
		hasReturn = true;

	}

	public void visit(DesignatorAssign designatorAssign) {
		if (designatorAssign.getDesignator().obj.getKind() == Obj.Meth) {
			report_error("Nemoguce dodeliti pozivu metode vrednost", designatorAssign);
			return;
		}
		if (designatorAssign.getExpr().struct.getKind()==designatorAssign.getDesignator().obj.getType().getKind()) {
			return;
		}
		report_error("Tipovi su nekompatibilni", designatorAssign);
	}

	// inkrementiranje vrednosti
	public void visit(DesignatorIncrement designatorIncrement) {
		if (designatorIncrement.getDesignator().obj.getKind() == Obj.Meth) {
			report_error("Nemoguce inkrementirati poziv metode", designatorIncrement);
		}
		if (!designatorIncrement.getDesignator().obj.getType().equals(Tab.intType)) {
			report_error("Nemoguce inkrementirati promenljivu koja nije ceo broj", designatorIncrement);
		}
	}

	// dekrementiranje vrednosti
	public void visit(DesignatorDecrement designatorDec) {
		if (designatorDec.getDesignator().obj.getKind() == Obj.Meth) {
			report_error("Nemoguce dekrementirati poziv metode", designatorDec);
		}
		if (!designatorDec.getDesignator().obj.getType().equals(Tab.intType)) {
			report_error("Nemoguce dekrementirati promenljivu koja nije ceo broj", designatorDec);
		}
	}

	public void visit(DesignatorMethod desMethod) {

		if (Obj.Meth != desMethod.getDesignatorCalled().getDesignator().obj.getKind()) {
			report_error("Greska u pozivu metode", desMethod);
			return;
		}
	}

	public void visit(DoWhileStmt whileStmt) {
		// check break start

		if (breakLoop && breakLoopLine > whileStmt.getLine()
				&& breakLoopLine < whileStmt.getCondition().getLine() + whileStmt.getLine()) {
			breakLoop = false;
			report_info("Gotovo izvrsavanje petlje", whileStmt);
			// return;
			// System.out.println("Gotovo izvrsavanje petlje pronadjen break na liniji
			// "+breakLoopLine);
		} else if (breakLoop) {
			report_error("Break iskaz se poziva samo unutar do while petlje", whileStmt);
			breakLoop = false;
		}

		// check break end

		// check continue start
		if (continueLoop && continueLoopLine > whileStmt.getLine()
				&& continueLoopLine < whileStmt.getCondition().getLine() + whileStmt.getLine()) {
			continueLoop = false;
			report_info("Nailazak na continue unutar petlje", whileStmt);
		} else if (continueLoop) {
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
		if (!(readStmt.getDesignator().obj.getKind() == Obj.Elem || readStmt.getDesignator().obj.getKind() == Obj.Var
				|| readStmt.getDesignator().obj.getKind() == Obj.Fld)) {
			report_error("Polje u okviru read iskaza mora biti element niza ili promenljiva ili polje klase", readStmt);
			return;
		}
		if (!(readStmt.getDesignator().obj.getType().getKind() == Struct.Int
				|| readStmt.getDesignator().obj.getType().getKind() == Struct.Bool
				|| readStmt.getDesignator().obj.getType().getKind() == Struct.Char)) {
			report_error("Greska mogu se citati promenljive elementi niza ili polja u klasi", readStmt);
			return;
		}

	}

	// expr types
	public void visit(BaseNumber baseNumber) {
		baseNumber.struct = Tab.intType;
	}

	public void visit(BaseChar baseNumber) {
		baseNumber.struct = Tab.charType;
	}

	public void visit(BaseBool baseNumber) {
		baseNumber.struct = boolStruct;
	}

	public void visit(BaseNewRecord baseNumber) {
		baseNumber.struct = baseNumber.getType().struct;
	}

	public void visit(BaseNewArrayElem baseNumber) {
		Obj o = Tab.find(currentType.getTypeName());
		baseNumber.struct = new Struct(Struct.Array,o.getType());
		if (baseNumber.getExpr().struct != Tab.intType) {
			report_error("Element u okviru indeksiranja mora biti int", baseNumber);
			return;
		}
	}

	public void visit(BaseDesignator baseNumber) {
		baseNumber.struct = baseNumber.getDesignator().obj.getType();
	}

	public void visit(BaseExpr baseNumber) {
		baseNumber.struct = baseNumber.getExpr().struct;
	}

	public void visit(Termc termc) {
		termc.struct = termc.getFactor().struct;
		if (termc.getMulopFactorList().struct != null) {
			if (termc.struct.getKind() != Tab.intType.getKind()) {
				report_error("Operatori (*, MOD, /) zahtevaju int vrednosti", termc);
			}
		}
	}
	public void visit(TermMinusc termc) {
		termc.struct = termc.getTerm().struct;
	}

	public void visit(Factorc factor) {
		factor.struct = factor.getBaseExp().struct;
	}

	public void visit(Exprc expr) {

		if (expr.getTermMinus().struct != null && expr.getAddopTermList().struct != null
				&& expr.getTermMinus().struct.getKind() != expr.getAddopTermList().struct.getKind()) {
			report_error("Tipovi u okviru izraza su nekompatibilni", expr);
			return;
		}
		expr.struct = expr.getTermMinus().struct;

	}
	
	
	public void visit(AddopTermListc termList) {
		termList.struct = termList.getTerm().struct;

		if (termList.getAddopTermList().struct != null) {
			if (termList.struct.getKind() != termList.getAddopTermList().struct.getKind()) {
				report_error("Tipovi u okviru izraza su nekompatibilni", termList);
				return;
			}
		}

	}

	public void visit(MulopFactorListc mulopList) {
		mulopList.struct = mulopList.getFactor().struct;
		if (mulopList.struct.getKind() != Struct.Int) {
			report_error("Operatori (*, MOD, /) zahtevaju int vrednosti", mulopList);
		}
		// mulopList.getFactor().struct;
	}


	public void visit(ExprRelop exprRelop) {
		if (exprRelop.getExpr().struct.getKind() != exprRelop.getExpr1().struct.getKind()) {
			report_error("Tipovi koji se porede moraju biti istog tipa", exprRelop);

		}

	}

}
