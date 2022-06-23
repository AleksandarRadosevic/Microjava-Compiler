// generated with ast extension for cup
// version 0.8
// 24/5/2022 1:28:59


package rs.ac.bg.etf.pp1.ast;

public class FormParsOptionalDerived1 extends FormParsOptional {

    private FormPars FormPars;
    private VarArgs VarArgs;

    public FormParsOptionalDerived1 (FormPars FormPars, VarArgs VarArgs) {
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.VarArgs=VarArgs;
        if(VarArgs!=null) VarArgs.setParent(this);
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public VarArgs getVarArgs() {
        return VarArgs;
    }

    public void setVarArgs(VarArgs VarArgs) {
        this.VarArgs=VarArgs;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormPars!=null) FormPars.accept(visitor);
        if(VarArgs!=null) VarArgs.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(VarArgs!=null) VarArgs.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(VarArgs!=null) VarArgs.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsOptionalDerived1(\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarArgs!=null)
            buffer.append(VarArgs.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsOptionalDerived1]");
        return buffer.toString();
    }
}
