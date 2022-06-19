// generated with ast extension for cup
// version 0.8
// 19/5/2022 23:5:6


package src.rs.ac.bg.etf.pp1.ast;

public class ConstDeclc extends ConstDecl {

    private ConstDeclRepeat ConstDeclRepeat;
    private ConstDeclList ConstDeclList;

    public ConstDeclc (ConstDeclRepeat ConstDeclRepeat, ConstDeclList ConstDeclList) {
        this.ConstDeclRepeat=ConstDeclRepeat;
        if(ConstDeclRepeat!=null) ConstDeclRepeat.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
    }

    public ConstDeclRepeat getConstDeclRepeat() {
        return ConstDeclRepeat;
    }

    public void setConstDeclRepeat(ConstDeclRepeat ConstDeclRepeat) {
        this.ConstDeclRepeat=ConstDeclRepeat;
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclRepeat!=null) ConstDeclRepeat.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclRepeat!=null) ConstDeclRepeat.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclRepeat!=null) ConstDeclRepeat.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclc(\n");

        if(ConstDeclRepeat!=null)
            buffer.append(ConstDeclRepeat.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclc]");
        return buffer.toString();
    }
}
