// generated with ast extension for cup
// version 0.8
// 25/5/2022 1:1:36


package rs.ac.bg.etf.pp1.ast;

public class ExprCommaListc extends ExprCommaList {

    private ExprCommaList ExprCommaList;
    private ExprPar ExprPar;

    public ExprCommaListc (ExprCommaList ExprCommaList, ExprPar ExprPar) {
        this.ExprCommaList=ExprCommaList;
        if(ExprCommaList!=null) ExprCommaList.setParent(this);
        this.ExprPar=ExprPar;
        if(ExprPar!=null) ExprPar.setParent(this);
    }

    public ExprCommaList getExprCommaList() {
        return ExprCommaList;
    }

    public void setExprCommaList(ExprCommaList ExprCommaList) {
        this.ExprCommaList=ExprCommaList;
    }

    public ExprPar getExprPar() {
        return ExprPar;
    }

    public void setExprPar(ExprPar ExprPar) {
        this.ExprPar=ExprPar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprCommaList!=null) ExprCommaList.accept(visitor);
        if(ExprPar!=null) ExprPar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprCommaList!=null) ExprCommaList.traverseTopDown(visitor);
        if(ExprPar!=null) ExprPar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprCommaList!=null) ExprCommaList.traverseBottomUp(visitor);
        if(ExprPar!=null) ExprPar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprCommaListc(\n");

        if(ExprCommaList!=null)
            buffer.append(ExprCommaList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprPar!=null)
            buffer.append(ExprPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprCommaListc]");
        return buffer.toString();
    }
}
