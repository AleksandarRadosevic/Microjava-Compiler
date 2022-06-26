// generated with ast extension for cup
// version 0.8
// 26/5/2022 23:54:23


package rs.ac.bg.etf.pp1.ast;

public class ListBaseExpc extends ListBaseExp {

    private ListBaseExp ListBaseExp;
    private Expop Expop;
    private BaseExp BaseExp;

    public ListBaseExpc (ListBaseExp ListBaseExp, Expop Expop, BaseExp BaseExp) {
        this.ListBaseExp=ListBaseExp;
        if(ListBaseExp!=null) ListBaseExp.setParent(this);
        this.Expop=Expop;
        if(Expop!=null) Expop.setParent(this);
        this.BaseExp=BaseExp;
        if(BaseExp!=null) BaseExp.setParent(this);
    }

    public ListBaseExp getListBaseExp() {
        return ListBaseExp;
    }

    public void setListBaseExp(ListBaseExp ListBaseExp) {
        this.ListBaseExp=ListBaseExp;
    }

    public Expop getExpop() {
        return Expop;
    }

    public void setExpop(Expop Expop) {
        this.Expop=Expop;
    }

    public BaseExp getBaseExp() {
        return BaseExp;
    }

    public void setBaseExp(BaseExp BaseExp) {
        this.BaseExp=BaseExp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListBaseExp!=null) ListBaseExp.accept(visitor);
        if(Expop!=null) Expop.accept(visitor);
        if(BaseExp!=null) BaseExp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListBaseExp!=null) ListBaseExp.traverseTopDown(visitor);
        if(Expop!=null) Expop.traverseTopDown(visitor);
        if(BaseExp!=null) BaseExp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListBaseExp!=null) ListBaseExp.traverseBottomUp(visitor);
        if(Expop!=null) Expop.traverseBottomUp(visitor);
        if(BaseExp!=null) BaseExp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListBaseExpc(\n");

        if(ListBaseExp!=null)
            buffer.append(ListBaseExp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expop!=null)
            buffer.append(Expop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BaseExp!=null)
            buffer.append(BaseExp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListBaseExpc]");
        return buffer.toString();
    }
}
