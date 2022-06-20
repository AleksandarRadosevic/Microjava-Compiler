// generated with ast extension for cup
// version 0.8
// 20/5/2022 21:18:47


package rs.ac.bg.etf.pp1.ast;

public class DeclListMethodc extends DeclListMethod {

    private DeclListMethod DeclListMethod;
    private MethodDecl MethodDecl;

    public DeclListMethodc (DeclListMethod DeclListMethod, MethodDecl MethodDecl) {
        this.DeclListMethod=DeclListMethod;
        if(DeclListMethod!=null) DeclListMethod.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public DeclListMethod getDeclListMethod() {
        return DeclListMethod;
    }

    public void setDeclListMethod(DeclListMethod DeclListMethod) {
        this.DeclListMethod=DeclListMethod;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclListMethod!=null) DeclListMethod.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclListMethod!=null) DeclListMethod.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclListMethod!=null) DeclListMethod.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclListMethodc(\n");

        if(DeclListMethod!=null)
            buffer.append(DeclListMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclListMethodc]");
        return buffer.toString();
    }
}
