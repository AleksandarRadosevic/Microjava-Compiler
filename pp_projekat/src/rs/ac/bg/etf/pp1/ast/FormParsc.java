// generated with ast extension for cup
// version 0.8
// 24/5/2022 1:28:59


package rs.ac.bg.etf.pp1.ast;

public class FormParsc extends FormPars {

    private Pars Pars;
    private ParsList ParsList;

    public FormParsc (Pars Pars, ParsList ParsList) {
        this.Pars=Pars;
        if(Pars!=null) Pars.setParent(this);
        this.ParsList=ParsList;
        if(ParsList!=null) ParsList.setParent(this);
    }

    public Pars getPars() {
        return Pars;
    }

    public void setPars(Pars Pars) {
        this.Pars=Pars;
    }

    public ParsList getParsList() {
        return ParsList;
    }

    public void setParsList(ParsList ParsList) {
        this.ParsList=ParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Pars!=null) Pars.accept(visitor);
        if(ParsList!=null) ParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Pars!=null) Pars.traverseTopDown(visitor);
        if(ParsList!=null) ParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Pars!=null) Pars.traverseBottomUp(visitor);
        if(ParsList!=null) ParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsc(\n");

        if(Pars!=null)
            buffer.append(Pars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ParsList!=null)
            buffer.append(ParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsc]");
        return buffer.toString();
    }
}
