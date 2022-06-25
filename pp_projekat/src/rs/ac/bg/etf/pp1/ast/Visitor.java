// generated with ast extension for cup
// version 0.8
// 25/5/2022 20:2:27


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Expop Expop);
    public void visit(VarDeclGlobal VarDeclGlobal);
    public void visit(DeclarationList DeclarationList);
    public void visit(ActParsOptional ActParsOptional);
    public void visit(OptionalNumConst OptionalNumConst);
    public void visit(DeclListVar DeclListVar);
    public void visit(MethodDecl MethodDecl);
    public void visit(Mulop Mulop);
    public void visit(ConstructorDecl ConstructorDecl);
    public void visit(DeclListMethod DeclListMethod);
    public void visit(ExprCommaList ExprCommaList);
    public void visit(Relop Relop);
    public void visit(Assignop Assignop);
    public void visit(LabelColon LabelColon);
    public void visit(MulopFactorList MulopFactorList);
    public void visit(ParsList ParsList);
    public void visit(Pars Pars);
    public void visit(OptionalExtends OptionalExtends);
    public void visit(StatementList StatementList);
    public void visit(Addop Addop);
    public void visit(OptionalBraces OptionalBraces);
    public void visit(RecordDecl RecordDecl);
    public void visit(ConditionIf ConditionIf);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(DeclList DeclList);
    public void visit(Designator Designator);
    public void visit(Term Term);
    public void visit(OptConstructorMethod OptConstructorMethod);
    public void visit(Condition Condition);
    public void visit(FormParsOptional FormParsOptional);
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
    public void visit(MethodTypeName MethodTypeName);
    public void visit(VarArgs VarArgs);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ProgName ProgName);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(DesignatorStatementElements DesignatorStatementElements);
    public void visit(Type Type);
    public void visit(BaseExp BaseExp);
    public void visit(ClassDecl ClassDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(OptionalExpression OptionalExpression);
    public void visit(Program Program);
    public void visit(VarDeclListGlobal VarDeclListGlobal);
    public void visit(ListBaseExp ListBaseExp);
    public void visit(SingleStatement SingleStatement);
    public void visit(CondFactListAnd CondFactListAnd);
    public void visit(FormPars FormPars);
    public void visit(OptionalElse OptionalElse);
    public void visit(AddopTermList AddopTermList);
    public void visit(VarArgsc VarArgsc);
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
    public void visit(DesignatorName DesignatorName);
    public void visit(ArrayElemClass ArrayElemClass);
    public void visit(DesignatorDerived1 DesignatorDerived1);
    public void visit(ArrayElem ArrayElem);
    public void visit(Designatorc Designatorc);
    public void visit(DesignatorCalled DesignatorCalled);
    public void visit(FuncCall FuncCall);
    public void visit(BaseDesignator BaseDesignator);
    public void visit(BaseExpr BaseExpr);
    public void visit(BaseNewArrayElem BaseNewArrayElem);
    public void visit(BaseNewRecord BaseNewRecord);
    public void visit(BaseBool BaseBool);
    public void visit(BaseChar BaseChar);
    public void visit(BaseNumber BaseNumber);
    public void visit(NoListBaseExpc NoListBaseExpc);
    public void visit(ListBaseExpc ListBaseExpc);
    public void visit(Expopc Expopc);
    public void visit(Factorc Factorc);
    public void visit(NoMulopFactorList NoMulopFactorList);
    public void visit(MulopFactorListc MulopFactorListc);
    public void visit(Termc Termc);
    public void visit(NoAddopTermList NoAddopTermList);
    public void visit(AddopTermListc AddopTermListc);
    public void visit(NoOptionalMinus NoOptionalMinus);
    public void visit(OptionalMinus OptionalMinus);
    public void visit(Exprc Exprc);
    public void visit(ExprRelop ExprRelop);
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
    public void visit(ExprPar ExprPar);
    public void visit(ActParsc ActParsc);
    public void visit(NoActPars NoActPars);
    public void visit(ActParsOptionalc ActParsOptionalc);
    public void visit(DesignatorStatementElementsDerived3 DesignatorStatementElementsDerived3);
    public void visit(DesignatorStatementElementsDerived2 DesignatorStatementElementsDerived2);
    public void visit(DesignatorStatementElementsDerived1 DesignatorStatementElementsDerived1);
    public void visit(DesignatorStatementElementsc DesignatorStatementElementsc);
    public void visit(DesignatorDecrement DesignatorDecrement);
    public void visit(DesignatorIncrement DesignatorIncrement);
    public void visit(DesignatorMethod DesignatorMethod);
    public void visit(DesignatorAssign DesignatorAssign);
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
    public void visit(DoWhileStmt DoWhileStmt);
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
    public void visit(ParsDerived1 ParsDerived1);
    public void visit(Parsc Parsc);
    public void visit(ErrorFormPars ErrorFormPars);
    public void visit(FormParsc FormParsc);
    public void visit(FormParsOptionalDerived3 FormParsOptionalDerived3);
    public void visit(FormParsOptionalDerived2 FormParsOptionalDerived2);
    public void visit(FormParsOptionalDerived1 FormParsOptionalDerived1);
    public void visit(FormParsOptionalc FormParsOptionalc);
    public void visit(TypeOrVoidDerived1 TypeOrVoidDerived1);
    public void visit(TypeOrVoidc TypeOrVoidc);
    public void visit(VoidFunc VoidFunc);
    public void visit(MethodTypeNamec MethodTypeNamec);
    public void visit(MethodDeclc MethodDeclc);
    public void visit(ConstructorDeclc ConstructorDeclc);
    public void visit(RecordName RecordName);
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
    public void visit(NoVarDeclListGlobalc NoVarDeclListGlobalc);
    public void visit(VarDeclListGlobalc VarDeclListGlobalc);
    public void visit(NoVarDeclList NoVarDeclList);
    public void visit(VarDeclListc VarDeclListc);
    public void visit(NoOptionalBraces NoOptionalBraces);
    public void visit(OptionalBracesc OptionalBracesc);
    public void visit(VarDeclc VarDeclc);
    public void visit(VarDeclGlobalc VarDeclGlobalc);
    public void visit(NoConstDecl NoConstDecl);
    public void visit(ErrorComma ErrorComma);
    public void visit(ConstDeclListc ConstDeclListc);
    public void visit(ConstBool ConstBool);
    public void visit(ConstChar ConstChar);
    public void visit(ConstInt ConstInt);
    public void visit(ErrorConstDeclEnd ErrorConstDeclEnd);
    public void visit(ConstDeclc ConstDeclc);
    public void visit(DeclListDerived3 DeclListDerived3);
    public void visit(DeclListDerived2 DeclListDerived2);
    public void visit(DeclListDerived1 DeclListDerived1);
    public void visit(DeclListc DeclListc);
    public void visit(NoDeclarations NoDeclarations);
    public void visit(DeclarationListc DeclarationListc);
    public void visit(ProgNamec ProgNamec);
    public void visit(Programc Programc);

}
