// generated with ast extension for cup
// version 0.8
// 21/5/2022 0:17:36


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementc extends DesignatorStatement {

    private Designator Designator;
    private DesignatorStatementElements DesignatorStatementElements;

    public DesignatorStatementc (Designator Designator, DesignatorStatementElements DesignatorStatementElements) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DesignatorStatementElements=DesignatorStatementElements;
        if(DesignatorStatementElements!=null) DesignatorStatementElements.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DesignatorStatementElements getDesignatorStatementElements() {
        return DesignatorStatementElements;
    }

    public void setDesignatorStatementElements(DesignatorStatementElements DesignatorStatementElements) {
        this.DesignatorStatementElements=DesignatorStatementElements;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DesignatorStatementElements!=null) DesignatorStatementElements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DesignatorStatementElements!=null) DesignatorStatementElements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DesignatorStatementElements!=null) DesignatorStatementElements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementc(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementElements!=null)
            buffer.append(DesignatorStatementElements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementc]");
        return buffer.toString();
    }
}
