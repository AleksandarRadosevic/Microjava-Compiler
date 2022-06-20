// generated with ast extension for cup
// version 0.8
// 20/5/2022 21:18:47


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclc extends MethodDecl {

    private TypeOrVoid TypeOrVoid;
    private String I2;
    private FormParsOptional FormParsOptional;
    private DeclListVar DeclListVar;
    private StatementList StatementList;

    public MethodDeclc (TypeOrVoid TypeOrVoid, String I2, FormParsOptional FormParsOptional, DeclListVar DeclListVar, StatementList StatementList) {
        this.TypeOrVoid=TypeOrVoid;
        if(TypeOrVoid!=null) TypeOrVoid.setParent(this);
        this.I2=I2;
        this.FormParsOptional=FormParsOptional;
        if(FormParsOptional!=null) FormParsOptional.setParent(this);
        this.DeclListVar=DeclListVar;
        if(DeclListVar!=null) DeclListVar.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public TypeOrVoid getTypeOrVoid() {
        return TypeOrVoid;
    }

    public void setTypeOrVoid(TypeOrVoid TypeOrVoid) {
        this.TypeOrVoid=TypeOrVoid;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public FormParsOptional getFormParsOptional() {
        return FormParsOptional;
    }

    public void setFormParsOptional(FormParsOptional FormParsOptional) {
        this.FormParsOptional=FormParsOptional;
    }

    public DeclListVar getDeclListVar() {
        return DeclListVar;
    }

    public void setDeclListVar(DeclListVar DeclListVar) {
        this.DeclListVar=DeclListVar;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeOrVoid!=null) TypeOrVoid.accept(visitor);
        if(FormParsOptional!=null) FormParsOptional.accept(visitor);
        if(DeclListVar!=null) DeclListVar.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeOrVoid!=null) TypeOrVoid.traverseTopDown(visitor);
        if(FormParsOptional!=null) FormParsOptional.traverseTopDown(visitor);
        if(DeclListVar!=null) DeclListVar.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeOrVoid!=null) TypeOrVoid.traverseBottomUp(visitor);
        if(FormParsOptional!=null) FormParsOptional.traverseBottomUp(visitor);
        if(DeclListVar!=null) DeclListVar.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclc(\n");

        if(TypeOrVoid!=null)
            buffer.append(TypeOrVoid.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(FormParsOptional!=null)
            buffer.append(FormParsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclListVar!=null)
            buffer.append(DeclListVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclc]");
        return buffer.toString();
    }
}
