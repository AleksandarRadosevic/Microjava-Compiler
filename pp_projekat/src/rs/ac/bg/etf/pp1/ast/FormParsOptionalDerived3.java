// generated with ast extension for cup
// version 0.8
// 25/5/2022 1:1:36


package rs.ac.bg.etf.pp1.ast;

public class FormParsOptionalDerived3 extends FormParsOptional {

    public FormParsOptionalDerived3 () {
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
        buffer.append("FormParsOptionalDerived3(\n");

        buffer.append(tab);
        buffer.append(") [FormParsOptionalDerived3]");
        return buffer.toString();
    }
}
