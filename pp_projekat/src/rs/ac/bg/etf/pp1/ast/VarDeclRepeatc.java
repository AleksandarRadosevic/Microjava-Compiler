// generated with ast extension for cup
// version 0.8
// 20/5/2022 1:16:5


package src.rs.ac.bg.etf.pp1.ast;

public class VarDeclRepeatc extends VarDeclRepeat {

    private String I1;
    private OptionalBraces OptionalBraces;

    public VarDeclRepeatc (String I1, OptionalBraces OptionalBraces) {
        this.I1=I1;
        this.OptionalBraces=OptionalBraces;
        if(OptionalBraces!=null) OptionalBraces.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public OptionalBraces getOptionalBraces() {
        return OptionalBraces;
    }

    public void setOptionalBraces(OptionalBraces OptionalBraces) {
        this.OptionalBraces=OptionalBraces;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalBraces!=null) OptionalBraces.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalBraces!=null) OptionalBraces.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalBraces!=null) OptionalBraces.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclRepeatc(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(OptionalBraces!=null)
            buffer.append(OptionalBraces.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclRepeatc]");
        return buffer.toString();
    }
}
