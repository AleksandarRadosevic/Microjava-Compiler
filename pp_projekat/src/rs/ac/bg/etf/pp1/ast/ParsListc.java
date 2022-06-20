// generated with ast extension for cup
// version 0.8
// 20/5/2022 11:7:40


package src.rs.ac.bg.etf.pp1.ast;

public class ParsListc extends ParsList {

    private ParsList ParsList;
    private Pars Pars;

    public ParsListc (ParsList ParsList, Pars Pars) {
        this.ParsList=ParsList;
        if(ParsList!=null) ParsList.setParent(this);
        this.Pars=Pars;
        if(Pars!=null) Pars.setParent(this);
    }

    public ParsList getParsList() {
        return ParsList;
    }

    public void setParsList(ParsList ParsList) {
        this.ParsList=ParsList;
    }

    public Pars getPars() {
        return Pars;
    }

    public void setPars(Pars Pars) {
        this.Pars=Pars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ParsList!=null) ParsList.accept(visitor);
        if(Pars!=null) Pars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ParsList!=null) ParsList.traverseTopDown(visitor);
        if(Pars!=null) Pars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ParsList!=null) ParsList.traverseBottomUp(visitor);
        if(Pars!=null) Pars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ParsListc(\n");

        if(ParsList!=null)
            buffer.append(ParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Pars!=null)
            buffer.append(Pars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ParsListc]");
        return buffer.toString();
    }
}
