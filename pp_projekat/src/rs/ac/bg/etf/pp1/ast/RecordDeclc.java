// generated with ast extension for cup
// version 0.8
// 19/5/2022 23:5:6


package src.rs.ac.bg.etf.pp1.ast;

public class RecordDeclc extends RecordDecl {

    private DeclListVar DeclListVar;

    public RecordDeclc (DeclListVar DeclListVar) {
        this.DeclListVar=DeclListVar;
        if(DeclListVar!=null) DeclListVar.setParent(this);
    }

    public DeclListVar getDeclListVar() {
        return DeclListVar;
    }

    public void setDeclListVar(DeclListVar DeclListVar) {
        this.DeclListVar=DeclListVar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclListVar!=null) DeclListVar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclListVar!=null) DeclListVar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclListVar!=null) DeclListVar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDeclc(\n");

        if(DeclListVar!=null)
            buffer.append(DeclListVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecordDeclc]");
        return buffer.toString();
    }
}
