// generated with ast extension for cup
// version 0.8
// 25/5/2022 20:2:27


package rs.ac.bg.etf.pp1.ast;

public class DeclListDerived1 extends DeclList {

    private VarDeclGlobal VarDeclGlobal;

    public DeclListDerived1 (VarDeclGlobal VarDeclGlobal) {
        this.VarDeclGlobal=VarDeclGlobal;
        if(VarDeclGlobal!=null) VarDeclGlobal.setParent(this);
    }

    public VarDeclGlobal getVarDeclGlobal() {
        return VarDeclGlobal;
    }

    public void setVarDeclGlobal(VarDeclGlobal VarDeclGlobal) {
        this.VarDeclGlobal=VarDeclGlobal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclGlobal!=null) VarDeclGlobal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclGlobal!=null) VarDeclGlobal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclGlobal!=null) VarDeclGlobal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclListDerived1(\n");

        if(VarDeclGlobal!=null)
            buffer.append(VarDeclGlobal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclListDerived1]");
        return buffer.toString();
    }
}
