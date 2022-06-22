// generated with ast extension for cup
// version 0.8
// 22/5/2022 15:59:35


package rs.ac.bg.etf.pp1.ast;

public class VarDeclListGlobalc extends VarDeclListGlobal {

    private VarDeclListGlobal VarDeclListGlobal;
    private String I2;
    private OptionalBraces OptionalBraces;

    public VarDeclListGlobalc (VarDeclListGlobal VarDeclListGlobal, String I2, OptionalBraces OptionalBraces) {
        this.VarDeclListGlobal=VarDeclListGlobal;
        if(VarDeclListGlobal!=null) VarDeclListGlobal.setParent(this);
        this.I2=I2;
        this.OptionalBraces=OptionalBraces;
        if(OptionalBraces!=null) OptionalBraces.setParent(this);
    }

    public VarDeclListGlobal getVarDeclListGlobal() {
        return VarDeclListGlobal;
    }

    public void setVarDeclListGlobal(VarDeclListGlobal VarDeclListGlobal) {
        this.VarDeclListGlobal=VarDeclListGlobal;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
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
        if(VarDeclListGlobal!=null) VarDeclListGlobal.accept(visitor);
        if(OptionalBraces!=null) OptionalBraces.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclListGlobal!=null) VarDeclListGlobal.traverseTopDown(visitor);
        if(OptionalBraces!=null) OptionalBraces.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclListGlobal!=null) VarDeclListGlobal.traverseBottomUp(visitor);
        if(OptionalBraces!=null) OptionalBraces.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclListGlobalc(\n");

        if(VarDeclListGlobal!=null)
            buffer.append(VarDeclListGlobal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(OptionalBraces!=null)
            buffer.append(OptionalBraces.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclListGlobalc]");
        return buffer.toString();
    }
}
