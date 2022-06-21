// generated with ast extension for cup
// version 0.8
// 21/5/2022 11:58:1


package rs.ac.bg.etf.pp1.ast;

public class DesignatorDerived1 extends Designator {

    private DesignatorName DesignatorName;
    private DesignatorName DesignatorName1;

    public DesignatorDerived1 (DesignatorName DesignatorName, DesignatorName DesignatorName1) {
        this.DesignatorName=DesignatorName;
        if(DesignatorName!=null) DesignatorName.setParent(this);
        this.DesignatorName1=DesignatorName1;
        if(DesignatorName1!=null) DesignatorName1.setParent(this);
    }

    public DesignatorName getDesignatorName() {
        return DesignatorName;
    }

    public void setDesignatorName(DesignatorName DesignatorName) {
        this.DesignatorName=DesignatorName;
    }

    public DesignatorName getDesignatorName1() {
        return DesignatorName1;
    }

    public void setDesignatorName1(DesignatorName DesignatorName1) {
        this.DesignatorName1=DesignatorName1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorName!=null) DesignatorName.accept(visitor);
        if(DesignatorName1!=null) DesignatorName1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorName!=null) DesignatorName.traverseTopDown(visitor);
        if(DesignatorName1!=null) DesignatorName1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorName!=null) DesignatorName.traverseBottomUp(visitor);
        if(DesignatorName1!=null) DesignatorName1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorDerived1(\n");

        if(DesignatorName!=null)
            buffer.append(DesignatorName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorName1!=null)
            buffer.append(DesignatorName1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorDerived1]");
        return buffer.toString();
    }
}
