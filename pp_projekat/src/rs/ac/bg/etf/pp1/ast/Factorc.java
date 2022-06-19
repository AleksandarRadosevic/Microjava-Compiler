// generated with ast extension for cup
// version 0.8
// 20/5/2022 1:16:5


package src.rs.ac.bg.etf.pp1.ast;

public class Factorc extends Factor {

    private Designator Designator;
    private ActParsBracesOptional ActParsBracesOptional;

    public Factorc (Designator Designator, ActParsBracesOptional ActParsBracesOptional) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsBracesOptional=ActParsBracesOptional;
        if(ActParsBracesOptional!=null) ActParsBracesOptional.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsBracesOptional getActParsBracesOptional() {
        return ActParsBracesOptional;
    }

    public void setActParsBracesOptional(ActParsBracesOptional ActParsBracesOptional) {
        this.ActParsBracesOptional=ActParsBracesOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsBracesOptional!=null) ActParsBracesOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsBracesOptional!=null) ActParsBracesOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsBracesOptional!=null) ActParsBracesOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factorc(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsBracesOptional!=null)
            buffer.append(ActParsBracesOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factorc]");
        return buffer.toString();
    }
}
