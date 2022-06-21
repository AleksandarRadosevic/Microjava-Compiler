// generated with ast extension for cup
// version 0.8
// 21/5/2022 11:58:1


package rs.ac.bg.etf.pp1.ast;

public class VarDeclListc extends VarDeclList {

    private VarDeclList VarDeclList;
    private String I2;
    private OptionalBraces OptionalBraces;

    public VarDeclListc (VarDeclList VarDeclList, String I2, OptionalBraces OptionalBraces) {
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.I2=I2;
        this.OptionalBraces=OptionalBraces;
        if(OptionalBraces!=null) OptionalBraces.setParent(this);
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
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
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(OptionalBraces!=null) OptionalBraces.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(OptionalBraces!=null) OptionalBraces.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(OptionalBraces!=null) OptionalBraces.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclListc(\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
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
        buffer.append(") [VarDeclListc]");
        return buffer.toString();
    }
}
