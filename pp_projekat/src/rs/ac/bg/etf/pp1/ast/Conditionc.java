// generated with ast extension for cup
// version 0.8
// 27/5/2022 12:7:9


package rs.ac.bg.etf.pp1.ast;

public class Conditionc extends Condition {

    private CondTerm CondTerm;
    private CondTermListOr CondTermListOr;

    public Conditionc (CondTerm CondTerm, CondTermListOr CondTermListOr) {
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
        this.CondTermListOr=CondTermListOr;
        if(CondTermListOr!=null) CondTermListOr.setParent(this);
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public CondTermListOr getCondTermListOr() {
        return CondTermListOr;
    }

    public void setCondTermListOr(CondTermListOr CondTermListOr) {
        this.CondTermListOr=CondTermListOr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTerm!=null) CondTerm.accept(visitor);
        if(CondTermListOr!=null) CondTermListOr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
        if(CondTermListOr!=null) CondTermListOr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        if(CondTermListOr!=null) CondTermListOr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Conditionc(\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTermListOr!=null)
            buffer.append(CondTermListOr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Conditionc]");
        return buffer.toString();
    }
}
