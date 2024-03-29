// generated with ast extension for cup
// version 0.8
// 27/5/2022 21:22:58


package rs.ac.bg.etf.pp1.ast;

public class Programc extends Program {

    private ProgName ProgName;
    private DeclarationList DeclarationList;
    private DeclListMethod DeclListMethod;

    public Programc (ProgName ProgName, DeclarationList DeclarationList, DeclListMethod DeclListMethod) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.DeclarationList=DeclarationList;
        if(DeclarationList!=null) DeclarationList.setParent(this);
        this.DeclListMethod=DeclListMethod;
        if(DeclListMethod!=null) DeclListMethod.setParent(this);
    }

    public ProgName getProgName() {
        return ProgName;
    }

    public void setProgName(ProgName ProgName) {
        this.ProgName=ProgName;
    }

    public DeclarationList getDeclarationList() {
        return DeclarationList;
    }

    public void setDeclarationList(DeclarationList DeclarationList) {
        this.DeclarationList=DeclarationList;
    }

    public DeclListMethod getDeclListMethod() {
        return DeclListMethod;
    }

    public void setDeclListMethod(DeclListMethod DeclListMethod) {
        this.DeclListMethod=DeclListMethod;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgName!=null) ProgName.accept(visitor);
        if(DeclarationList!=null) DeclarationList.accept(visitor);
        if(DeclListMethod!=null) DeclListMethod.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(DeclarationList!=null) DeclarationList.traverseTopDown(visitor);
        if(DeclListMethod!=null) DeclListMethod.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(DeclarationList!=null) DeclarationList.traverseBottomUp(visitor);
        if(DeclListMethod!=null) DeclListMethod.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Programc(\n");

        if(ProgName!=null)
            buffer.append(ProgName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclarationList!=null)
            buffer.append(DeclarationList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclListMethod!=null)
            buffer.append(DeclListMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Programc]");
        return buffer.toString();
    }
}
