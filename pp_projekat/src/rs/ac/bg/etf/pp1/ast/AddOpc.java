// generated with ast extension for cup
// version 0.8
// 20/5/2022 17:36:31


package rs.ac.bg.etf.pp1.ast;

public class AddOpc extends Addop {

    public AddOpc () {
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
        buffer.append("AddOpc(\n");

        buffer.append(tab);
        buffer.append(") [AddOpc]");
        return buffer.toString();
    }
}
