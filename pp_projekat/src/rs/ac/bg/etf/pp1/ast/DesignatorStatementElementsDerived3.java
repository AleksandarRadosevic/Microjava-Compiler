// generated with ast extension for cup
// version 0.8
// 24/5/2022 15:43:50


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementElementsDerived3 extends DesignatorStatementElements {

    public DesignatorStatementElementsDerived3 () {
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
        buffer.append("DesignatorStatementElementsDerived3(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementElementsDerived3]");
        return buffer.toString();
    }
}
