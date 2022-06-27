package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;

	public int getMainPc() {
		return mainPc;
	}

	public void setMainPc(int mainPc) {
		this.mainPc = mainPc;
	}

	public void visit(PrintStmt printStmt) {
		if (printStmt.getExpr().struct == Tab.intType) {
			Code.loadConst(5);
			Code.put(Code.print);
		} else if (printStmt.getExpr().struct.getKind() != new Struct(Struct.Bool).getKind()) {
			Code.loadConst(1);
			Code.put(Code.bprint);
		} else {
			Code.loadConst(5);
			Code.put(Code.print);
		}
	}

	// value types
	// non const values start
	// ------------------------------------------------------------------------------------
	public void visit(BaseNumber cnst) {
		Code.loadConst(cnst.getN1());
	}

	public void visit(BaseChar cnst) {
		Code.loadConst(cnst.getC1());
	}

	public void visit(BaseBool cnst) {
		if (cnst.getB1() == true) {
			Code.loadConst(1);
		} else {
			Code.loadConst(0);
		}
	}
	// ------------------------------------------------------------------------------------
	// non const values end

	// const values start
	// ------------------------------------------------------------------------------------

	public void visit(ConstInt cnst) {
		Code.loadConst(cnst.getN1());
	}

	public void visit(ConstChar cnst) {
		Code.loadConst(cnst.getC1());

	}

	public void visit(ConstBool cnst) {
		if (cnst.getB1() == true) {
			Code.loadConst(1);
		} else {
			Code.loadConst(0);
		}
	}
	// ------------------------------------------------------------------------------------
	// const values end

	// initialization values
	// const

	public void visit(BaseDesignator d) {
		if (d.getDesignator().obj.getKind() == Obj.Elem)
			Code.load(d.getDesignator().obj);
	}

	public void visit(MethodTypeNamec methodTypeName) {
		if ("main".equalsIgnoreCase(methodTypeName.getMethodName())) {
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
		if ("main".equalsIgnoreCase(methodTypeName.getMethodName())) {
			mainPc = Code.pc;
		}
		methodTypeName.obj.setAdr(Code.pc);
		// Collect local variables
		SyntaxNode methodNode = methodTypeName.getParent();

		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);

		// Generate the entry
		Code.put(Code.enter);
		Code.put(0);
		Code.put(varCnt.getCount());
	}

	public void visit(MethodDeclc methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);

	}

	public void visit(FuncCall funcCall) {

	}

	public void visit(Designatorc designator) {
		Code.load(designator.obj);
		
		
	}

	public void visit(DesignatorNameArr d) {
		Code.load(d.obj);

	}

	public void visit(DesignatorAssign assign) {
		Code.store(assign.getDesignator().obj);
	}

	public void visit(DesignatorIncrement incr) {

		// if elem is elem of array
		if (incr.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(incr.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(incr.getDesignator().obj);
	}

	public void visit(DesignatorDecrement decr) {
		if (decr.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(decr.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(decr.getDesignator().obj);
	}

	public void visit(TermMinusc expr) {
		if (expr.getOptionalMinus() instanceof OptionalMinusc)
			Code.put(Code.neg);
	}

	public void visit(AddopTermListc op) {
		if (op.getAddop() instanceof OperationPlus)
			Code.put(Code.add);
		else
			Code.put(Code.sub);
	}

	public void visit(MulopFactorListc op) {
		if (op.getMulop() instanceof OperationMul) {
			Code.put(Code.mul);
		} else if (op.getMulop() instanceof OperationDiv) {
			Code.put(Code.div);
		} else
			Code.put(Code.rem);
	}

	public void visit(ReadStmt stmt) {
		if (stmt.getDesignator().obj.getType().getKind() == Tab.charType.getKind()) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}
		Code.store(stmt.getDesignator().obj);
	}

	public void visit(BaseNewArrayElem newArr) {
		Code.put(Code.newarray);
		if (newArr.getType().struct == Tab.charType) {
			Code.put(0);
		} else
			Code.put(1);
	}

//	public void visit(OneElementExp elem) {
//		Code.put(Code.pop);
//		if (elem.getBaseExp() instanceof BaseNumber) {
//			BaseNumber num = (BaseNumber) elem.getBaseExp();
//			int val = num.getN1();
//			// remove from stack added number
//			//Code.put(Code.pop);
//			if (val < 0) {
//
//			} else if (val == 0) {
//
//				Code.put(Code.dup);
//				Code.put(Code.div);
//				return;
//			}
//			if (val > 1) {
//				for (int i = 0; i < val - 1; i++) {
//					Code.put(Code.dup);
//				}
//				for (int i = 0; i < val - 1; i++) {
//					Code.put(Code.mul);
//				}
//			}
//
//		}
//		else {
//			int val = Code.pc;
//			for (int i = 0; i < 1; i++) {
//				Code.put(Code.dup);
//			}
//			for (int i = 0; i < 1; i++) {
//				Code.put(Code.mul);
//			}
//		}
//	}
	public void visit(OneElementExp exp) {
		Code.put(Code.enter);
		Code.put(2);
		Code.put(4);
		Code.put(Code.const_1);
		Code.put(Code.store_2);
		Code.put(Code.const_n);
		Code.put(Code.store_3);
		
		int labelFirst=Code.pc;
		Code.put(Code.load_3);
		Code.put(Code.load_1);
		Code.put(Code.jcc+Code.ge);
		int cond=Code.pc;
		Code.put2(0);
		
		Code.put(Code.load_n);
		Code.put(Code.load_2);
		Code.put(Code.mul);
		Code.put(Code.store_2);
		
		Code.put(Code.load_3);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.store_3);
		
		Code.put(Code.jmp);
		int val = labelFirst-Code.pc+1;
		Code.put2(labelFirst-Code.pc+1);
		
		Code.fixup(cond);
		Code.put(Code.load_2);
		Code.put(Code.exit);
	}
}
