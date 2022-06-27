// generated with ast extension for cup
// version 0.8
// 27/5/2022 17:1:59


package rs.ac.bg.etf.pp1.ast;

public class VarDeclGlobalc extends VarDeclGlobal {

    private Type Type;
    private String varName;
    private OptionalBraces OptionalBraces;
    private VarDeclListGlobal VarDeclListGlobal;

    public VarDeclGlobalc (Type Type, String varName, OptionalBraces OptionalBraces, VarDeclListGlobal VarDeclListGlobal) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.varName=varName;
        this.OptionalBraces=OptionalBraces;
        if(OptionalBraces!=null) OptionalBraces.setParent(this);
        this.VarDeclListGlobal=VarDeclListGlobal;
        if(VarDeclListGlobal!=null) VarDeclListGlobal.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public OptionalBraces getOptionalBraces() {
        return OptionalBraces;
    }

    public void setOptionalBraces(OptionalBraces OptionalBraces) {
        this.OptionalBraces=OptionalBraces;
    }

    public VarDeclListGlobal getVarDeclListGlobal() {
        return VarDeclListGlobal;
    }

    public void setVarDeclListGlobal(VarDeclListGlobal VarDeclListGlobal) {
        this.VarDeclListGlobal=VarDeclListGlobal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(OptionalBraces!=null) OptionalBraces.accept(visitor);
        if(VarDeclListGlobal!=null) VarDeclListGlobal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalBraces!=null) OptionalBraces.traverseTopDown(visitor);
        if(VarDeclListGlobal!=null) VarDeclListGlobal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalBraces!=null) OptionalBraces.traverseBottomUp(visitor);
        if(VarDeclListGlobal!=null) VarDeclListGlobal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclGlobalc(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(OptionalBraces!=null)
            buffer.append(OptionalBraces.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclListGlobal!=null)
            buffer.append(VarDeclListGlobal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclGlobalc]");
        return buffer.toString();
    }
}
