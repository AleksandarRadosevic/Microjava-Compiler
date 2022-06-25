// generated with ast extension for cup
// version 0.8
// 25/5/2022 20:2:27


package rs.ac.bg.etf.pp1.ast;

public class FuncCall extends BaseExp {

    private DesignatorCalled DesignatorCalled;
    private ActParsOptional ActParsOptional;

    public FuncCall (DesignatorCalled DesignatorCalled, ActParsOptional ActParsOptional) {
        this.DesignatorCalled=DesignatorCalled;
        if(DesignatorCalled!=null) DesignatorCalled.setParent(this);
        this.ActParsOptional=ActParsOptional;
        if(ActParsOptional!=null) ActParsOptional.setParent(this);
    }

    public DesignatorCalled getDesignatorCalled() {
        return DesignatorCalled;
    }

    public void setDesignatorCalled(DesignatorCalled DesignatorCalled) {
        this.DesignatorCalled=DesignatorCalled;
    }

    public ActParsOptional getActParsOptional() {
        return ActParsOptional;
    }

    public void setActParsOptional(ActParsOptional ActParsOptional) {
        this.ActParsOptional=ActParsOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorCalled!=null) DesignatorCalled.accept(visitor);
        if(ActParsOptional!=null) ActParsOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorCalled!=null) DesignatorCalled.traverseTopDown(visitor);
        if(ActParsOptional!=null) ActParsOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorCalled!=null) DesignatorCalled.traverseBottomUp(visitor);
        if(ActParsOptional!=null) ActParsOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FuncCall(\n");

        if(DesignatorCalled!=null)
            buffer.append(DesignatorCalled.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsOptional!=null)
            buffer.append(ActParsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FuncCall]");
        return buffer.toString();
    }
}
