// generated with ast extension for cup
// version 0.8
// 22/5/2022 12:55:29


package rs.ac.bg.etf.pp1.ast;

public class CondFactc extends CondFact {

    private Expr Expr;
    private RelopOprOptional RelopOprOptional;

    public CondFactc (Expr Expr, RelopOprOptional RelopOprOptional) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.RelopOprOptional=RelopOprOptional;
        if(RelopOprOptional!=null) RelopOprOptional.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public RelopOprOptional getRelopOprOptional() {
        return RelopOprOptional;
    }

    public void setRelopOprOptional(RelopOprOptional RelopOprOptional) {
        this.RelopOprOptional=RelopOprOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(RelopOprOptional!=null) RelopOprOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(RelopOprOptional!=null) RelopOprOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(RelopOprOptional!=null) RelopOprOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactc(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RelopOprOptional!=null)
            buffer.append(RelopOprOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactc]");
        return buffer.toString();
    }
}
