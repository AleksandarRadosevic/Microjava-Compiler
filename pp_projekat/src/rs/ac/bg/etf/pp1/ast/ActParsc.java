// generated with ast extension for cup
// version 0.8
// 25/5/2022 20:2:27


package rs.ac.bg.etf.pp1.ast;

public class ActParsc extends ActPars {

    private ExprPar ExprPar;
    private ExprCommaList ExprCommaList;

    public ActParsc (ExprPar ExprPar, ExprCommaList ExprCommaList) {
        this.ExprPar=ExprPar;
        if(ExprPar!=null) ExprPar.setParent(this);
        this.ExprCommaList=ExprCommaList;
        if(ExprCommaList!=null) ExprCommaList.setParent(this);
    }

    public ExprPar getExprPar() {
        return ExprPar;
    }

    public void setExprPar(ExprPar ExprPar) {
        this.ExprPar=ExprPar;
    }

    public ExprCommaList getExprCommaList() {
        return ExprCommaList;
    }

    public void setExprCommaList(ExprCommaList ExprCommaList) {
        this.ExprCommaList=ExprCommaList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprPar!=null) ExprPar.accept(visitor);
        if(ExprCommaList!=null) ExprCommaList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprPar!=null) ExprPar.traverseTopDown(visitor);
        if(ExprCommaList!=null) ExprCommaList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprPar!=null) ExprPar.traverseBottomUp(visitor);
        if(ExprCommaList!=null) ExprCommaList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsc(\n");

        if(ExprPar!=null)
            buffer.append(ExprPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprCommaList!=null)
            buffer.append(ExprCommaList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsc]");
        return buffer.toString();
    }
}
