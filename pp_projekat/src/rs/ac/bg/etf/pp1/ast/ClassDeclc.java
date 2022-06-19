// generated with ast extension for cup
// version 0.8
// 19/5/2022 23:5:6


package src.rs.ac.bg.etf.pp1.ast;

public class ClassDeclc extends ClassDecl {

    private OptionalExtends OptionalExtends;
    private DeclListVar DeclListVar;
    private OptConstructorMethod OptConstructorMethod;

    public ClassDeclc (OptionalExtends OptionalExtends, DeclListVar DeclListVar, OptConstructorMethod OptConstructorMethod) {
        this.OptionalExtends=OptionalExtends;
        if(OptionalExtends!=null) OptionalExtends.setParent(this);
        this.DeclListVar=DeclListVar;
        if(DeclListVar!=null) DeclListVar.setParent(this);
        this.OptConstructorMethod=OptConstructorMethod;
        if(OptConstructorMethod!=null) OptConstructorMethod.setParent(this);
    }

    public OptionalExtends getOptionalExtends() {
        return OptionalExtends;
    }

    public void setOptionalExtends(OptionalExtends OptionalExtends) {
        this.OptionalExtends=OptionalExtends;
    }

    public DeclListVar getDeclListVar() {
        return DeclListVar;
    }

    public void setDeclListVar(DeclListVar DeclListVar) {
        this.DeclListVar=DeclListVar;
    }

    public OptConstructorMethod getOptConstructorMethod() {
        return OptConstructorMethod;
    }

    public void setOptConstructorMethod(OptConstructorMethod OptConstructorMethod) {
        this.OptConstructorMethod=OptConstructorMethod;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalExtends!=null) OptionalExtends.accept(visitor);
        if(DeclListVar!=null) DeclListVar.accept(visitor);
        if(OptConstructorMethod!=null) OptConstructorMethod.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalExtends!=null) OptionalExtends.traverseTopDown(visitor);
        if(DeclListVar!=null) DeclListVar.traverseTopDown(visitor);
        if(OptConstructorMethod!=null) OptConstructorMethod.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalExtends!=null) OptionalExtends.traverseBottomUp(visitor);
        if(DeclListVar!=null) DeclListVar.traverseBottomUp(visitor);
        if(OptConstructorMethod!=null) OptConstructorMethod.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclc(\n");

        if(OptionalExtends!=null)
            buffer.append(OptionalExtends.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclListVar!=null)
            buffer.append(DeclListVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptConstructorMethod!=null)
            buffer.append(OptConstructorMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclc]");
        return buffer.toString();
    }
}
