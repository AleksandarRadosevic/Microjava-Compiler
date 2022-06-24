// generated with ast extension for cup
// version 0.8
// 24/5/2022 15:43:50


package rs.ac.bg.etf.pp1.ast;

public class ReturnStmt extends SingleStatement {

    private OptionalExpression OptionalExpression;

    public ReturnStmt (OptionalExpression OptionalExpression) {
        this.OptionalExpression=OptionalExpression;
        if(OptionalExpression!=null) OptionalExpression.setParent(this);
    }

    public OptionalExpression getOptionalExpression() {
        return OptionalExpression;
    }

    public void setOptionalExpression(OptionalExpression OptionalExpression) {
        this.OptionalExpression=OptionalExpression;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalExpression!=null) OptionalExpression.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalExpression!=null) OptionalExpression.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalExpression!=null) OptionalExpression.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStmt(\n");

        if(OptionalExpression!=null)
            buffer.append(OptionalExpression.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStmt]");
        return buffer.toString();
    }
}
