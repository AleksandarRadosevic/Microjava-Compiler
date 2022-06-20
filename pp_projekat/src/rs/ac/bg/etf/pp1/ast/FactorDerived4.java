// generated with ast extension for cup
// version 0.8
// 21/5/2022 0:17:36


package rs.ac.bg.etf.pp1.ast;

public class FactorDerived4 extends Factor {

    private Type Type;
    private ExprBracesOptional ExprBracesOptional;

    public FactorDerived4 (Type Type, ExprBracesOptional ExprBracesOptional) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ExprBracesOptional=ExprBracesOptional;
        if(ExprBracesOptional!=null) ExprBracesOptional.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(ExprBracesOptional!=null) ExprBracesOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ExprBracesOptional!=null) ExprBracesOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ExprBracesOptional!=null) ExprBracesOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDerived4(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprBracesOptional!=null)
            buffer.append(ExprBracesOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDerived4]");
        return buffer.toString();
    }
}
