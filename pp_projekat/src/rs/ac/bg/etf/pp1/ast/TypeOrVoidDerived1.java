// generated with ast extension for cup
// version 0.8
// 22/5/2022 12:55:29


package rs.ac.bg.etf.pp1.ast;

public class TypeOrVoidDerived1 extends TypeOrVoid {

    public TypeOrVoidDerived1 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TypeOrVoidDerived1(\n");

        buffer.append(tab);
        buffer.append(") [TypeOrVoidDerived1]");
        return buffer.toString();
    }
}
