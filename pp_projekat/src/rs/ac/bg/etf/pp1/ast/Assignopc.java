// generated with ast extension for cup
// version 0.8
// 23/5/2022 21:16:23


package rs.ac.bg.etf.pp1.ast;

public class Assignopc extends Assignop {

    public Assignopc () {
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
        buffer.append("Assignopc(\n");

        buffer.append(tab);
        buffer.append(") [Assignopc]");
        return buffer.toString();
    }
}
