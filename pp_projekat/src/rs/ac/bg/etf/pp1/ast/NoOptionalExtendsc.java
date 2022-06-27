// generated with ast extension for cup
// version 0.8
// 27/5/2022 12:7:9


package rs.ac.bg.etf.pp1.ast;

public class NoOptionalExtendsc extends OptionalExtends {

    public NoOptionalExtendsc () {
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
        buffer.append("NoOptionalExtendsc(\n");

        buffer.append(tab);
        buffer.append(") [NoOptionalExtendsc]");
        return buffer.toString();
    }
}
