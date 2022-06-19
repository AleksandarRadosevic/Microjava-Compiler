// generated with ast extension for cup
// version 0.8
// 19/5/2022 23:5:6


package src.rs.ac.bg.etf.pp1.ast;

public class VarDeclRepeatc extends VarDeclRepeat {

    private Type Type;
    private OptionalBraces OptionalBraces;

    public VarDeclRepeatc (Type Type, OptionalBraces OptionalBraces) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.OptionalBraces=OptionalBraces;
        if(OptionalBraces!=null) OptionalBraces.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(OptionalBraces!=null) OptionalBraces.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalBraces!=null) OptionalBraces.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalBraces!=null) OptionalBraces.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclRepeatc(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
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
