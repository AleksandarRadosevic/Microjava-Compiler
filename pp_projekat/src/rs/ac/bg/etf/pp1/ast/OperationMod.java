// generated with ast extension for cup
// version 0.8
// 27/5/2022 21:22:58


package rs.ac.bg.etf.pp1.ast;

public class OperationMod extends Mulop {

    public OperationMod () {
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
        buffer.append("OperationMod(\n");

        buffer.append(tab);
        buffer.append(") [OperationMod]");
        return buffer.toString();
    }
}
