package typeChecker;

import types.BoolType;
import types.IntType;
import types.MoneyType;
import expr.Ident;
import expr.arithmeticExpr.Add;
import expr.arithmeticExpr.Div;
import expr.arithmeticExpr.Mul;
import expr.arithmeticExpr.Sub;
import expr.conditionalExpr.And;
import expr.conditionalExpr.Or;
import expr.relationalExpr.Eq;
import expr.relationalExpr.GEq;
import expr.relationalExpr.GT;
import expr.relationalExpr.LEq;
import expr.relationalExpr.LT;
import expr.relationalExpr.NEq;
import expr.signExpr.Neg;
import expr.signExpr.Not;
import expr.signExpr.Pos;
import expr.syntacticExpr.Form;
import expr.syntacticExpr.IfBlock;
import expr.syntacticExpr.Question;
import expr.syntacticExpr.QuestionBody;
import expr.literals.*;

public abstract class ASTVisitor {

	public void visit(Ident ident) {}
	
	public void visit(Add add)  {}
	public void visit(Div div)  {}
	public void visit(Mul mul)  {}
	public void visit(Sub sub)  {}
	
	public void visit(And and)  {}
	public void visit(Or or)  {}

	public void visit(Eq eq)  {}
	public void visit(GEq gEq)  {}
	public void visit(GT gt)  {}
	public void visit(LEq lEq)  {}
	public void visit(LT lt) {}
	public void visit(NEq nEq) {}

	public void visit(Neg neg) {}
	public void visit(Not not) {}
	public void visit(Pos pos) {}

	public void visit(Bool bool) {}
	public void visit(Int int1) {}
	
	public void visit(BoolType bool) {}
	public void visit(IntType intType) {}
	public void visit(MoneyType moneyType) {}

	public void visit(Form form) {}
	public void visit(IfBlock ifBlock) {}
	public void visit(Question question) {}
	public void visit(QuestionBody questionBody) {}	
}
