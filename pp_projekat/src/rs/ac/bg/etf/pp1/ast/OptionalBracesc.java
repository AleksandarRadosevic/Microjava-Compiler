// generated with ast extension for cup
// version 0.8
// 21/5/2022 0:17:36


package rs.ac.bg.etf.pp1.ast;

public class OptionalBracesc extends OptionalBraces {

    public OptionalBracesc () {
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
        buffer.append("OptionalBracesc(\n");

        buffer.append(tab);
        buffer.append(") [OptionalBracesc]");
        return buffer.toString();
    }
}