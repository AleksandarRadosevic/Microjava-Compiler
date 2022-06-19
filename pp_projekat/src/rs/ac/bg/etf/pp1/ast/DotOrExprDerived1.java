// generated with ast extension for cup
// version 0.8
// 19/5/2022 23:5:6


package src.rs.ac.bg.etf.pp1.ast;

public class DotOrExprDerived1 extends DotOrExpr {

    private ExprBracesOptional ExprBracesOptional;

    public DotOrExprDerived1 (ExprBracesOptional ExprBracesOptional) {
        this.ExprBracesOptional=ExprBracesOptional;
        if(ExprBracesOptional!=null) ExprBracesOptional.setParent(this);
    }

    public ExprBracesOptional getExprBracesOptional() {
        return ExprBracesOptional;
    }

    public void setExprBracesOptional(ExprBracesOptional ExprBracesOptional) {
        this.ExprBracesOptional=ExprBracesOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprBracesOptional!=null) ExprBracesOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprBracesOptional!=null) ExprBracesOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprBracesOptional!=null) ExprBracesOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DotOrExprDerived1(\n");

        if(ExprBracesOptional!=null)
            buffer.append(ExprBracesOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DotOrExprDerived1]");
        return buffer.toString();
    }
}
