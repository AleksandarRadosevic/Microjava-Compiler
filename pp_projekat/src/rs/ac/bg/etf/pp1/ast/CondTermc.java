// generated with ast extension for cup
// version 0.8
// 27/5/2022 12:7:9


package rs.ac.bg.etf.pp1.ast;

public class CondTermc extends CondTerm {

    private CondFact CondFact;
    private CondFactListAnd CondFactListAnd;

    public CondTermc (CondFact CondFact, CondFactListAnd CondFactListAnd) {
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
        this.CondFactListAnd=CondFactListAnd;
        if(CondFactListAnd!=null) CondFactListAnd.setParent(this);
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public CondFactListAnd getCondFactListAnd() {
        return CondFactListAnd;
    }

    public void setCondFactListAnd(CondFactListAnd CondFactListAnd) {
        this.CondFactListAnd=CondFactListAnd;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFact!=null) CondFact.accept(visitor);
        if(CondFactListAnd!=null) CondFactListAnd.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
        if(CondFactListAnd!=null) CondFactListAnd.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        if(CondFactListAnd!=null) CondFactListAnd.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermc(\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFactListAnd!=null)
            buffer.append(CondFactListAnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermc]");
        return buffer.toString();
    }
}
