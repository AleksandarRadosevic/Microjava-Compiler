// generated with ast extension for cup
// version 0.8
// 22/5/2022 15:59:35


package rs.ac.bg.etf.pp1.ast;

public class OptConstructorMethodc extends OptConstructorMethod {

    private DeclListMethod DeclListMethod;

    public OptConstructorMethodc (DeclListMethod DeclListMethod) {
        this.DeclListMethod=DeclListMethod;
        if(DeclListMethod!=null) DeclListMethod.setParent(this);
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
        if(DeclListMethod!=null) DeclListMethod.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclListMethod!=null) DeclListMethod.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclListMethod!=null) DeclListMethod.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptConstructorMethodc(\n");

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
