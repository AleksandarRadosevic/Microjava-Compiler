// generated with ast extension for cup
// version 0.8
// 20/5/2022 21:18:47


package rs.ac.bg.etf.pp1.ast;

public class FactorDerived3 extends Factor {

    private Integer B1;

    public FactorDerived3 (Integer B1) {
        this.B1=B1;
    }

    public Integer getB1() {
        return B1;
    }

    public void setB1(Integer B1) {
        this.B1=B1;
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
        buffer.append("FactorDerived3(\n");

        buffer.append(" "+tab+B1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDerived3]");
        return buffer.toString();
    }
}
