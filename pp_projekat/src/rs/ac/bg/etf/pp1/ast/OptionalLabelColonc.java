// generated with ast extension for cup
// version 0.8
// 19/5/2022 23:5:6


package src.rs.ac.bg.etf.pp1.ast;

public class OptionalLabelColonc extends OptionalLabelColon {

    private LabelColon LabelColon;

    public OptionalLabelColonc (LabelColon LabelColon) {
        this.LabelColon=LabelColon;
        if(LabelColon!=null) LabelColon.setParent(this);
    }

    public LabelColon getLabelColon() {
        return LabelColon;
    }

    public void setLabelColon(LabelColon LabelColon) {
        this.LabelColon=LabelColon;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LabelColon!=null) LabelColon.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LabelColon!=null) LabelColon.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LabelColon!=null) LabelColon.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalLabelColonc(\n");

        if(LabelColon!=null)
            buffer.append(LabelColon.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalLabelColonc]");
        return buffer.toString();
    }
}
