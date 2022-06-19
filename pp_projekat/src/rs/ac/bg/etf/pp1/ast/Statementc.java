// generated with ast extension for cup
// version 0.8
// 19/5/2022 23:5:6


package src.rs.ac.bg.etf.pp1.ast;

public class Statementc extends Statement {

    private OptionalLabelColon OptionalLabelColon;
    private SingleStatement SingleStatement;

    public Statementc (OptionalLabelColon OptionalLabelColon, SingleStatement SingleStatement) {
        this.OptionalLabelColon=OptionalLabelColon;
        if(OptionalLabelColon!=null) OptionalLabelColon.setParent(this);
        this.SingleStatement=SingleStatement;
        if(SingleStatement!=null) SingleStatement.setParent(this);
    }

    public OptionalLabelColon getOptionalLabelColon() {
        return OptionalLabelColon;
    }

    public void setOptionalLabelColon(OptionalLabelColon OptionalLabelColon) {
        this.OptionalLabelColon=OptionalLabelColon;
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
        if(OptionalLabelColon!=null) OptionalLabelColon.accept(visitor);
        if(SingleStatement!=null) SingleStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalLabelColon!=null) OptionalLabelColon.traverseTopDown(visitor);
        if(SingleStatement!=null) SingleStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalLabelColon!=null) OptionalLabelColon.traverseBottomUp(visitor);
        if(SingleStatement!=null) SingleStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statementc(\n");

        if(OptionalLabelColon!=null)
            buffer.append(OptionalLabelColon.toString("  "+tab));
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
