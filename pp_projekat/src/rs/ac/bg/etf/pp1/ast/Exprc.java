// generated with ast extension for cup
// version 0.8
// 27/5/2022 12:7:9


package rs.ac.bg.etf.pp1.ast;

public class Exprc extends Expr {

    private TermMinus TermMinus;
    private AddopTermList AddopTermList;

    public Exprc (TermMinus TermMinus, AddopTermList AddopTermList) {
        this.TermMinus=TermMinus;
        if(TermMinus!=null) TermMinus.setParent(this);
        this.AddopTermList=AddopTermList;
        if(AddopTermList!=null) AddopTermList.setParent(this);
    }

    public TermMinus getTermMinus() {
        return TermMinus;
    }

    public void setTermMinus(TermMinus TermMinus) {
        this.TermMinus=TermMinus;
    }

    public AddopTermList getAddopTermList() {
        return AddopTermList;
    }

    public void setAddopTermList(AddopTermList AddopTermList) {
        this.AddopTermList=AddopTermList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermMinus!=null) TermMinus.accept(visitor);
        if(AddopTermList!=null) AddopTermList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermMinus!=null) TermMinus.traverseTopDown(visitor);
        if(AddopTermList!=null) AddopTermList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermMinus!=null) TermMinus.traverseBottomUp(visitor);
        if(AddopTermList!=null) AddopTermList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Exprc(\n");

        if(TermMinus!=null)
            buffer.append(TermMinus.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopTermList!=null)
            buffer.append(AddopTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Exprc]");
        return buffer.toString();
    }
}
