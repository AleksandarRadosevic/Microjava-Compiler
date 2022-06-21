// generated with ast extension for cup
// version 0.8
// 21/5/2022 11:58:1


package rs.ac.bg.etf.pp1.ast;

public class NoDeclListVar extends DeclListVar {

    public NoDeclListVar () {
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
        buffer.append("NoDeclListVar(\n");

        buffer.append(tab);
        buffer.append(") [NoDeclListVar]");
        return buffer.toString();
    }
}
