// generated with ast extension for cup
// version 0.8
// 22/5/2022 13:57:32


package rs.ac.bg.etf.pp1.ast;

public class IdentListc extends IdentList {

    private IdentList IdentList;
    private IdentListelem IdentListelem;

    public IdentListc (IdentList IdentList, IdentListelem IdentListelem) {
        this.IdentList=IdentList;
        if(IdentList!=null) IdentList.setParent(this);
        this.IdentListelem=IdentListelem;
        if(IdentListelem!=null) IdentListelem.setParent(this);
    }

    public IdentList getIdentList() {
        return IdentList;
    }

    public void setIdentList(IdentList IdentList) {
        this.IdentList=IdentList;
    }

    public IdentListelem getIdentListelem() {
        return IdentListelem;
    }

    public void setIdentListelem(IdentListelem IdentListelem) {
        this.IdentListelem=IdentListelem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentList!=null) IdentList.accept(visitor);
        if(IdentListelem!=null) IdentListelem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentList!=null) IdentList.traverseTopDown(visitor);
        if(IdentListelem!=null) IdentListelem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentList!=null) IdentList.traverseBottomUp(visitor);
        if(IdentListelem!=null) IdentListelem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentListc(\n");

        if(IdentList!=null)
            buffer.append(IdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentListelem!=null)
            buffer.append(IdentListelem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentListc]");
        return buffer.toString();
    }
}
