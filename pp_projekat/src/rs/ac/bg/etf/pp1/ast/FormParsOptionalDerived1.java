// generated with ast extension for cup
// version 0.8
// 21/5/2022 11:58:1


package rs.ac.bg.etf.pp1.ast;

public class FormParsOptionalDerived1 extends FormParsOptional {

    public FormParsOptionalDerived1 () {
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
        buffer.append("FormParsOptionalDerived1(\n");

        buffer.append(tab);
        buffer.append(") [FormParsOptionalDerived1]");
        return buffer.toString();
    }
}
