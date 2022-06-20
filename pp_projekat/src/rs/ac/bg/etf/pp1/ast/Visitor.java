// generated with ast extension for cup
// version 0.8
// 20/5/2022 21:18:47


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(DeclarationList DeclarationList);
    public void visit(ActParsOptional ActParsOptional);
    public void visit(OptionalNumConst OptionalNumConst);
    public void visit(DeclListVar DeclListVar);
    public void visit(Mulop Mulop);
    public void visit(MethodDecl MethodDecl);
    public void visit(ConstructorDecl ConstructorDecl);
    public void visit(ExprCommaList ExprCommaList);
    public void visit(DeclListMethod DeclListMethod);
    public void visit(Relop Relop);
    public void visit(Assignop Assignop);
    public void visit(LabelColon LabelColon);
    public void visit(MulopFactorList MulopFactorList);
    public void visit(ParsList ParsList);
    public void visit(DotOrExpr DotOrExpr);
    public void visit(Pars Pars);
    public void visit(OptionalExtends OptionalExtends);
    public void visit(ActParsBracesOptional ActParsBracesOptional);
    public void visit(StatementList StatementList);
    public void visit(Addop Addop);
    public void visit(OptionalBraces OptionalBraces);
    public void visit(ExprBracesOptional ExprBracesOptional);
    public void visit(ConditionIf ConditionIf);
    public void visit(RecordDecl RecordDecl);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(DeclList DeclList);
    public void visit(Designator Designator);
    public void visit(Term Term);
    public void visit(OptConstructorMethod OptConstructorMethod);
    public void visit(RelopOprOptional RelopOprOptional);
    public void visit(Condition Condition);
    public void visit(FormParsOptional FormParsOptional);
    public void visit(IdentList IdentList);
    public void visit(Statements Statements);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(CondTermListOr CondTermListOr);
    public void visit(Label Label);
    public void visit(OptionalConstructorDecl OptionalConstructorDecl);
    public void visit(VarDeclList VarDeclList);
    public void visit(Expr Expr);
    public void visit(ConstVal ConstVal);
    public void visit(ActPars ActPars);
    public void visit(TypeOrVoid TypeOrVoid);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(DesignatorStatementElements DesignatorStatementElements);
    public void visit(Type Type);
    public void visit(ClassDecl ClassDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(OptionalExpression OptionalExpression);
    public void visit(Program Program);
    public void visit(SingleStatement SingleStatement);
    public void visit(CondFactListAnd CondFactListAnd);
    public void visit(FormPars FormPars);
    public void visit(OptionalElse OptionalElse);
    public void visit(AddopTermList AddopTermList);
    public void visit(MulopDerived2 MulopDerived2);
    public void visit(MulopDerived1 MulopDerived1);
    public void visit(Mulopc Mulopc);
    public void visit(AddopDerived1 AddopDerived1);
    public void visit(AddOpc AddOpc);
    public void visit(RelopDerived5 RelopDerived5);
    public void visit(RelopDerived4 RelopDerived4);
    public void visit(RelopDerived3 RelopDerived3);
    public void visit(RelopDerived2 RelopDerived2);
    public void visit(RelopDerived1 RelopDerived1);
    public void visit(Relopc Relopc);
    public void visit(Assignopc Assignopc);
    public void visit(Labelc Labelc);
    public void visit(DotOrExprDerived1 DotOrExprDerived1);
    public void visit(DotOrExprc DotOrExprc);
    public void visit(IdentListDerived1 IdentListDerived1);
    public void visit(IdentListc IdentListc);
    public void visit(DesignatorDerived2 DesignatorDerived2);
    public void visit(DesignatorDerived1 DesignatorDerived1);
    public void visit(Designatorc Designatorc);
    public void visit(NoExprBracesOptional NoExprBracesOptional);
    public void visit(ExprBracesOptionalc ExprBracesOptionalc);
    public void visit(NoActParsBracesOptional NoActParsBracesOptional);
    public void visit(ActParsBracesOptionalc ActParsBracesOptionalc);
    public void visit(FactorDerived5 FactorDerived5);
    public void visit(FactorDerived4 FactorDerived4);
    public void visit(FactorDerived3 FactorDerived3);
    public void visit(FactorDerived2 FactorDerived2);
    public void visit(FactorDerived1 FactorDerived1);
    public void visit(Factorc Factorc);
    public void visit(NoMulopFactorList NoMulopFactorList);
    public void visit(MulopFactorListc MulopFactorListc);
    public void visit(Termc Termc);
    public void visit(NoAddopTermList NoAddopTermList);
    public void visit(AddopTermListc AddopTermListc);
    public void visit(NoOptionalMinus NoOptionalMinus);
    public void visit(OptionalMinus OptionalMinus);
    public void visit(Exprc Exprc);
    public void visit(NoRelopOprOptional NoRelopOprOptional);
    public void visit(RelopOprOptionalc RelopOprOptionalc);
    public void visit(CondFactc CondFactc);
    public void visit(NoCondFactListAnd NoCondFactListAnd);
    public void visit(CondFactListAndc CondFactListAndc);
    public void visit(CondTermc CondTermc);
    public void visit(NoCondTermListOr NoCondTermListOr);
    public void visit(CondTermListOrc CondTermListOrc);
    public void visit(Conditionc Conditionc);
    public void visit(ErrorConditionIf ErrorConditionIf);
    public void visit(ConditionIfc ConditionIfc);
    public void visit(NoExprCommaList NoExprCommaList);
    public void visit(ExprCommaListc ExprCommaListc);
    public void visit(ActParsc ActParsc);
    public void visit(NoActPars NoActPars);
    public void visit(ActParsOptionalc ActParsOptionalc);
    public void visit(DesignatorStatementElementsDerived3 DesignatorStatementElementsDerived3);
    public void visit(DesignatorStatementElementsDerived2 DesignatorStatementElementsDerived2);
    public void visit(DesignatorStatementElementsDerived1 DesignatorStatementElementsDerived1);
    public void visit(DesignatorStatementElementsc DesignatorStatementElementsc);
    public void visit(DesignatorStatementc DesignatorStatementc);
    public void visit(NoStatementList NoStatementList);
    public void visit(StatementListc StatementListc);
    public void visit(Statementsc Statementsc);
    public void visit(NoOptionalNumConst NoOptionalNumConst);
    public void visit(OptionalNumConstc OptionalNumConstc);
    public void visit(NoOptionalExpression NoOptionalExpression);
    public void visit(OptionalExpressionc OptionalExpressionc);
    public void visit(NoOptionalElse NoOptionalElse);
    public void visit(OptionalElsec OptionalElsec);
    public void visit(GotoStmt GotoStmt);
    public void visit(PrintStmt PrintStmt);
    public void visit(ReadStmt ReadStmt);
    public void visit(ReturnStmt ReturnStmt);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(BreakStmt BreakStmt);
    public void visit(DoStmt DoStmt);
    public void visit(NoElseStmt NoElseStmt);
    public void visit(IfStmt IfStmt);
    public void visit(SingleStatementc SingleStatementc);
    public void visit(LabelColonc LabelColonc);
    public void visit(StatementDerived2 StatementDerived2);
    public void visit(StatementDerived1 StatementDerived1);
    public void visit(ErrorStmt ErrorStmt);
    public void visit(Statementc Statementc);
    public void visit(Typec Typec);
    public void visit(NoParsList NoParsList);
    public void visit(ParsListc ParsListc);
    public void visit(Parsc Parsc);
    public void visit(ErrorFormPars ErrorFormPars);
    public void visit(FormParsc FormParsc);
    public void visit(FormParsOptionalDerived1 FormParsOptionalDerived1);
    public void visit(FormParsOptionalc FormParsOptionalc);
    public void visit(TypeOrVoidDerived1 TypeOrVoidDerived1);
    public void visit(TypeOrVoidc TypeOrVoidc);
    public void visit(MethodDeclc MethodDeclc);
    public void visit(ConstructorDeclc ConstructorDeclc);
    public void visit(RecordDeclc RecordDeclc);
    public void visit(NoDeclListMethod NoDeclListMethod);
    public void visit(DeclListMethodc DeclListMethodc);
    public void visit(NoOptionalConstructorDecl NoOptionalConstructorDecl);
    public void visit(OptionalConstructorDeclc OptionalConstructorDeclc);
    public void visit(NoOptConstructorMethod NoOptConstructorMethod);
    public void visit(OptConstructorMethodc OptConstructorMethodc);
    public void visit(NoDeclListVar NoDeclListVar);
    public void visit(DeclListVarc DeclListVarc);
    public void visit(NoOptionalExtendsc NoOptionalExtendsc);
    public void visit(OptionalExtendsc OptionalExtendsc);
    public void visit(ClassDeclc ClassDeclc);
    public void visit(NoVarDeclList NoVarDeclList);
    public void visit(VarDeclListc VarDeclListc);
    public void visit(NoOptionalBraces NoOptionalBraces);
    public void visit(OptionalBracesc OptionalBracesc);
    public void visit(VarDeclc VarDeclc);
    public void visit(NoConstDecl NoConstDecl);
    public void visit(ErrorComma ErrorComma);
    public void visit(ConstDeclListc ConstDeclListc);
    public void visit(ConstValDerived2 ConstValDerived2);
    public void visit(ConstValDerived1 ConstValDerived1);
    public void visit(ConstValc ConstValc);
    public void visit(ErrorConstDeclEnd ErrorConstDeclEnd);
    public void visit(ConstDeclc ConstDeclc);
    public void visit(DeclListDerived3 DeclListDerived3);
    public void visit(DeclListDerived2 DeclListDerived2);
    public void visit(DeclListDerived1 DeclListDerived1);
    public void visit(DeclListc DeclListc);
    public void visit(NoDeclarations NoDeclarations);
    public void visit(DeclarationListc DeclarationListc);
    public void visit(Programc Programc);

}
