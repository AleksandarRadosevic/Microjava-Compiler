package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor{
	
	private int mainPc;

	public int getMainPc() {
		return mainPc;
	}

	public void setMainPc(int mainPc) {
		this.mainPc = mainPc;
	}

	public void visit(PrintStmt printStmt){	
		
		if(printStmt.getExpr().struct == Tab.intType){
			Code.loadConst(5);
			Code.put(Code.print);
		}else if (printStmt.getExpr().struct.getKind()!=new Struct(Struct.Bool).getKind()){
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
		else {
			Code.loadConst(5);
			Code.put(Code.print);
		}
	}
	
	// value types
	public void visit(BaseNumber cnst){
		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		con.setAdr(cnst.getN1());
		Code.load(con);
		//Code.put(Code.neg);
	}
	public void visit(BaseChar cnst) {
		Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
		con.setLevel(0);
		con.setAdr(cnst.getC1());
		Code.load(con);
	}
	
	public void visit(BaseBool cnst) {
		if (cnst.getB1()==true) {
			Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
			con.setLevel(0);
			con.setAdr(1);
			Code.load(con);
		}
		else {
			Obj con = Tab.insert(Obj.Con, "$", cnst.struct);
			con.setLevel(0);
			con.setAdr(0);
			Code.load(con);
		}
		
	}
	
	
	public void visit(MethodTypeNamec methodTypeName){	
		if("main".equalsIgnoreCase(methodTypeName.getMethodName())){
			mainPc = Code.pc;
		}
		methodTypeName.obj.setAdr(Code.pc);
		// Collect arguments and local variables
		SyntaxNode methodNode = methodTypeName.getParent();
	
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount() + varCnt.getCount());
	
	}

	public void visit(VoidFunc methodTypeName) {
		if("main".equalsIgnoreCase(methodTypeName.getMethodName())){
			mainPc = Code.pc;
		}
		methodTypeName.obj.setAdr(Code.pc);
		// Collect  local variables
		SyntaxNode methodNode = methodTypeName.getParent();
	
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(0);
		Code.put(varCnt.getCount());
	}
	
	
	
	public void visit(MethodDeclc methodDecl){
		Code.put(Code.exit);
		Code.put(Code.return_);

	}
	
	public void visit(FuncCall funcCall) {
		
	}
	
	public void visit(Designatorc designator){
		Code.load(designator.obj);
	}
	
	public void visit (DesignatorAssign assign) {
		if (assign.getDesignator().obj.getKind()==5) {
			Code.put(Code.astore);
		}
		else Code.store(assign.getDesignator().obj);
	}
	
	public void visit(DesignatorIncrement incr) {
		Code.load(incr.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(incr.getDesignator().obj);
	}
	
	public void visit(DesignatorDecrement decr) {
		Code.load(decr.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(decr.getDesignator().obj);
	}
	
	public void visit (TermMinusc expr) {
		if (expr.getOptionalMinus() instanceof OptionalMinusc)
			Code.put(Code.neg);
	}
	
	
	public void visit (AddopTermListc op) {
		if (op.getAddop() instanceof OperationPlus)
			Code.put(Code.add);
		else 
			Code.put(Code.sub);
	}
	public void visit(MulopFactorListc op) {
		if (op.getMulop() instanceof OperationMul) {
			Code.put(Code.mul);
		}
		else if (op.getMulop() instanceof OperationDiv) {
			Code.put(Code.div);
		}
		else 
			Code.put(Code.rem);
	}
	public void visit(ReadStmt stmt) {
		if (stmt.getDesignator().obj.getType().getKind()==Tab.charType.getKind()) {
			Code.put(Code.bread);
		}
		else {
			Code.put(Code.read);
		}
		Code.store(stmt.getDesignator().obj);	
	}
	
	public void visit(BaseNewArrayElem newArr) {
		Code.put(Code.newarray);
		if (newArr.getType().struct==Tab.charType) {
			Code.put(0);
		}
		else Code.put(1);
	}
	
	public void visit(ArrayElem elem) {
		Code.put(Code.dup2);
		Code.load(elem.obj);
	}
	
}
