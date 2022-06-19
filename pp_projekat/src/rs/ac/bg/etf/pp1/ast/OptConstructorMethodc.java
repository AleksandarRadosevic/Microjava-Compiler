// generated with ast extension for cup
// version 0.8
// 19/5/2022 23:5:6


package src.rs.ac.bg.etf.pp1.ast;

public class OptConstructorMethodc extends OptConstructorMethod {

    private OptionalConstructorDecl OptionalConstructorDecl;
    private DeclListMethod DeclListMethod;

    public OptConstructorMethodc (OptionalConstructorDecl OptionalConstructorDecl, DeclListMethod DeclListMethod) {
        this.OptionalConstructorDecl=OptionalConstructorDecl;
        if(OptionalConstructorDecl!=null) OptionalConstructorDecl.setParent(this);
        this.DeclListMethod=DeclListMethod;
        if(DeclListMethod!=null) DeclListMethod.setParent(this);
    }

    public OptionalConstructorDecl getOptionalConstructorDecl() {
        return OptionalConstructorDecl;
    }

    public void setOptionalConstructorDecl(OptionalConstructorDecl OptionalConstructorDecl) {
        this.OptionalConstructorDecl=OptionalConstructorDecl;
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
        if(OptionalConstructorDecl!=null) OptionalConstructorDecl.accept(visitor);
        if(DeclListMethod!=null) DeclListMethod.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalConstructorDecl!=null) OptionalConstructorDecl.traverseTopDown(visitor);
        if(DeclListMethod!=null) DeclListMethod.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalConstructorDecl!=null) OptionalConstructorDecl.traverseBottomUp(visitor);
        if(DeclListMethod!=null) DeclListMethod.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptConstructorMethodc(\n");

        if(OptionalConstructorDecl!=null)
            buffer.append(OptionalConstructorDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclListMethod!=null)
            buffer.append(DeclListMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptConstructorMethodc]");
        return buffer.toString();
    }
}
