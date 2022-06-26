// generated with ast extension for cup
// version 0.8
// 26/5/2022 23:54:23


package rs.ac.bg.etf.pp1.ast;

public class Factorc extends Factor {

    private BaseExp BaseExp;
    private ListBaseExp ListBaseExp;

    public Factorc (BaseExp BaseExp, ListBaseExp ListBaseExp) {
        this.BaseExp=BaseExp;
        if(BaseExp!=null) BaseExp.setParent(this);
        this.ListBaseExp=ListBaseExp;
        if(ListBaseExp!=null) ListBaseExp.setParent(this);
    }

    public BaseExp getBaseExp() {
        return BaseExp;
    }

    public void setBaseExp(BaseExp BaseExp) {
        this.BaseExp=BaseExp;
    }

    public ListBaseExp getListBaseExp() {
        return ListBaseExp;
    }

    public void setListBaseExp(ListBaseExp ListBaseExp) {
        this.ListBaseExp=ListBaseExp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BaseExp!=null) BaseExp.accept(visitor);
        if(ListBaseExp!=null) ListBaseExp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BaseExp!=null) BaseExp.traverseTopDown(visitor);
        if(ListBaseExp!=null) ListBaseExp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BaseExp!=null) BaseExp.traverseBottomUp(visitor);
        if(ListBaseExp!=null) ListBaseExp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factorc(\n");

        if(BaseExp!=null)
            buffer.append(BaseExp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListBaseExp!=null)
            buffer.append(ListBaseExp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factorc]");
        return buffer.toString();
    }
}
