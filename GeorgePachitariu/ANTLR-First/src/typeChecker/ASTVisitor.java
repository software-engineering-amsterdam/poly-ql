package typeChecker;

import types.BoolType;
import types.IntType;
import types.MoneyType;
import expr.Ident;
import expr.arithmetic.Add;
import expr.arithmetic.Div;
import expr.arithmetic.Mul;
import expr.arithmetic.Sub;
import expr.conditional.And;
import expr.conditional.Or;
import expr.relational.Eq;
import expr.relational.GEq;
import expr.relational.GT;
import expr.relational.LEq;
import expr.relational.LT;
import expr.relational.NEq;
import expr.sign.Neg;
import expr.sign.Not;
import expr.sign.Pos;
import expr.syntactic.Form;
import expr.syntactic.IfBlock;
import expr.syntactic.Question;
import expr.syntactic.QuestionBody;
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
