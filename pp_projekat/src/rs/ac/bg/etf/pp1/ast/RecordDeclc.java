// generated with ast extension for cup
// version 0.8
// 25/5/2022 20:2:27


package rs.ac.bg.etf.pp1.ast;

public class RecordDeclc extends RecordDecl {

    private RecordName RecordName;
    private DeclListVar DeclListVar;

    public RecordDeclc (RecordName RecordName, DeclListVar DeclListVar) {
        this.RecordName=RecordName;
        if(RecordName!=null) RecordName.setParent(this);
        this.DeclListVar=DeclListVar;
        if(DeclListVar!=null) DeclListVar.setParent(this);
    }

    public RecordName getRecordName() {
        return RecordName;
    }

    public void setRecordName(RecordName RecordName) {
        this.RecordName=RecordName;
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
        if(RecordName!=null) RecordName.accept(visitor);
        if(DeclListVar!=null) DeclListVar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RecordName!=null) RecordName.traverseTopDown(visitor);
        if(DeclListVar!=null) DeclListVar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RecordName!=null) RecordName.traverseBottomUp(visitor);
        if(DeclListVar!=null) DeclListVar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDeclc(\n");

        if(RecordName!=null)
            buffer.append(RecordName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
