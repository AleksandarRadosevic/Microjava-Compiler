// generated with ast extension for cup
// version 0.8
// 19/5/2022 23:5:6


package src.rs.ac.bg.etf.pp1.ast;

public class IdentListc extends IdentList {

    private IdentList IdentList;
    private DotOrExpr DotOrExpr;

    public IdentListc (IdentList IdentList, DotOrExpr DotOrExpr) {
        this.IdentList=IdentList;
        if(IdentList!=null) IdentList.setParent(this);
        this.DotOrExpr=DotOrExpr;
        if(DotOrExpr!=null) DotOrExpr.setParent(this);
    }

    public IdentList getIdentList() {
        return IdentList;
    }

    public void setIdentList(IdentList IdentList) {
        this.IdentList=IdentList;
    }

    public DotOrExpr getDotOrExpr() {
        return DotOrExpr;
    }

    public void setDotOrExpr(DotOrExpr DotOrExpr) {
        this.DotOrExpr=DotOrExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentList!=null) IdentList.accept(visitor);
        if(DotOrExpr!=null) DotOrExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentList!=null) IdentList.traverseTopDown(visitor);
        if(DotOrExpr!=null) DotOrExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentList!=null) IdentList.traverseBottomUp(visitor);
        if(DotOrExpr!=null) DotOrExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentListc(\n");

        if(IdentList!=null)
            buffer.append(IdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DotOrExpr!=null)
            buffer.append(DotOrExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentListc]");
        return buffer.toString();
    }
}
