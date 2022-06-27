// generated with ast extension for cup
// version 0.8
// 27/5/2022 21:22:58


package rs.ac.bg.etf.pp1.ast;

public class ListBaseExpc extends ListBaseExp {

    private ListBaseExp ListBaseExp;
    private OneElementExp OneElementExp;

    public ListBaseExpc (ListBaseExp ListBaseExp, OneElementExp OneElementExp) {
        this.ListBaseExp=ListBaseExp;
        if(ListBaseExp!=null) ListBaseExp.setParent(this);
        this.OneElementExp=OneElementExp;
        if(OneElementExp!=null) OneElementExp.setParent(this);
    }

    public ListBaseExp getListBaseExp() {
        return ListBaseExp;
    }

    public void setListBaseExp(ListBaseExp ListBaseExp) {
        this.ListBaseExp=ListBaseExp;
    }

    public OneElementExp getOneElementExp() {
        return OneElementExp;
    }

    public void setOneElementExp(OneElementExp OneElementExp) {
        this.OneElementExp=OneElementExp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListBaseExp!=null) ListBaseExp.accept(visitor);
        if(OneElementExp!=null) OneElementExp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListBaseExp!=null) ListBaseExp.traverseTopDown(visitor);
        if(OneElementExp!=null) OneElementExp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListBaseExp!=null) ListBaseExp.traverseBottomUp(visitor);
        if(OneElementExp!=null) OneElementExp.traverseBottomUp(visitor);
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

        if(OneElementExp!=null)
            buffer.append(OneElementExp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListBaseExpc]");
        return buffer.toString();
    }
}
