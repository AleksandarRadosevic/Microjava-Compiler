// generated with ast extension for cup
// version 0.8
// 19/5/2022 23:5:6


package src.rs.ac.bg.etf.pp1.ast;

public class SingleStatementDerived7 extends SingleStatement {

    private Expr Expr;
    private OptionalNumConst OptionalNumConst;

    public SingleStatementDerived7 (Expr Expr, OptionalNumConst OptionalNumConst) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.OptionalNumConst=OptionalNumConst;
        if(OptionalNumConst!=null) OptionalNumConst.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public OptionalNumConst getOptionalNumConst() {
        return OptionalNumConst;
    }

    public void setOptionalNumConst(OptionalNumConst OptionalNumConst) {
        this.OptionalNumConst=OptionalNumConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(OptionalNumConst!=null) OptionalNumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(OptionalNumConst!=null) OptionalNumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(OptionalNumConst!=null) OptionalNumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleStatementDerived7(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalNumConst!=null)
            buffer.append(OptionalNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleStatementDerived7]");
        return buffer.toString();
    }
}
