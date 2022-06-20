// generated with ast extension for cup
// version 0.8
// 20/5/2022 11:7:40


package src.rs.ac.bg.etf.pp1.ast;

public class Programc extends Program {

    private String I1;
    private DeclarationList DeclarationList;
    private DeclListMethod DeclListMethod;

    public Programc (String I1, DeclarationList DeclarationList, DeclListMethod DeclListMethod) {
        this.I1=I1;
        this.DeclarationList=DeclarationList;
        if(DeclarationList!=null) DeclarationList.setParent(this);
        this.DeclListMethod=DeclListMethod;
        if(DeclListMethod!=null) DeclListMethod.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
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
        if(DeclarationList!=null) DeclarationList.accept(visitor);
        if(DeclListMethod!=null) DeclListMethod.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclarationList!=null) DeclarationList.traverseTopDown(visitor);
        if(DeclListMethod!=null) DeclListMethod.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclarationList!=null) DeclarationList.traverseBottomUp(visitor);
        if(DeclListMethod!=null) DeclListMethod.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Programc(\n");

        buffer.append(" "+tab+I1);
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
