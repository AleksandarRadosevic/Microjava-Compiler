// generated with ast extension for cup
// version 0.8
// 27/5/2022 21:22:58


package rs.ac.bg.etf.pp1.ast;

public class Statementc extends Statement {

    private LabelColon LabelColon;
    private SingleStatement SingleStatement;

    public Statementc (LabelColon LabelColon, SingleStatement SingleStatement) {
        this.LabelColon=LabelColon;
        if(LabelColon!=null) LabelColon.setParent(this);
        this.SingleStatement=SingleStatement;
        if(SingleStatement!=null) SingleStatement.setParent(this);
    }

    public LabelColon getLabelColon() {
        return LabelColon;
    }

    public void setLabelColon(LabelColon LabelColon) {
        this.LabelColon=LabelColon;
    }

    public SingleStatement getSingleStatement() {
        return SingleStatement;
    }

    public void setSingleStatement(SingleStatement SingleStatement) {
        this.SingleStatement=SingleStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LabelColon!=null) LabelColon.accept(visitor);
        if(SingleStatement!=null) SingleStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LabelColon!=null) LabelColon.traverseTopDown(visitor);
        if(SingleStatement!=null) SingleStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LabelColon!=null) LabelColon.traverseBottomUp(visitor);
        if(SingleStatement!=null) SingleStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statementc(\n");

        if(LabelColon!=null)
            buffer.append(LabelColon.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleStatement!=null)
            buffer.append(SingleStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statementc]");
        return buffer.toString();
    }
}
