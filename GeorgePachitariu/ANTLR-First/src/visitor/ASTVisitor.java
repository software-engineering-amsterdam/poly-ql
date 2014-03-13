package visitor;

import java.util.List;

import types.BoolType;
import types.IntType;
import types.MoneyType;
import types.Type;
import expr.Expression;
import expr.Ident;
import expr.arithmetic.Add;
import expr.arithmetic.Div;
import expr.arithmetic.Mul;
import expr.arithmetic.Sub;
import expr.conditional.And;
import expr.conditional.Or;
import expr.literals.Bool;
import expr.literals.Int;
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
import expr.syntactic.IfElseBlock;
import expr.syntactic.Question;
import expr.syntactic.QuestionBody;
import expr.syntactic.Statement;

public abstract class ASTVisitor {
	public void visit(Ident ident) {}

	private void visitOne(Expression operand) {
		operand.accept(this);
	}
	
	private void visitBoth( Expression leftHandOperand, Expression rightHandOperand) {
		leftHandOperand.accept(this);
		rightHandOperand.accept(this);
	}
	
	public void visit(Add add, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(Div div, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(Mul mul, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(Sub sub, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(And and, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(Or or, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(Eq eq, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(GEq gEq, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(GT gt, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(LEq lEq, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(LT lt, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(NEq nEq, Expression leftHandOperand, Expression rightHandOperand)  {
		this.visitBoth(leftHandOperand, rightHandOperand);
	}
	
	public void visit(Neg neg, Expression operand)  {
		this.visitOne(operand);
	}

	public void visit(Not not, Expression operand)  {
		this.visitOne(operand);
	}
	
	public void visit(Pos pos, Expression operand)  {
		this.visitOne(operand);
	}
	
	public void visit(Bool bool) {}
	public void visit(Int int1) {}

	public void visit(BoolType bool) {}
	public void visit(IntType intType) {}
	public void visit(MoneyType moneyType) {}
	
	public void visit(Form form, List<Statement> list) {
		for(Statement s : list)
			s.accept(this);
	}

	public void visit(IfBlock ifBlock, Expression condition, List<Statement> thenStatements) {
		condition.accept(this);
		for(Statement s : thenStatements)
			s.accept(this);
	}

	public void visit(IfElseBlock ifElseBlock,
			Expression condition, 
				List<Statement> thenStatements,
				List<Statement> elseStatements) {
		condition.accept(this);
		for(Statement s : thenStatements)
			s.accept(this);
		for(Statement s : elseStatements)
			s.accept(this);
	}

	public void visit(Question question, Ident ident, 
			QuestionBody questionBody, Type type, Expression expr) {
		ident.accept(this);
		questionBody.accept(this);
		type.accept(this);
		if(expr!=null)
			expr.accept(this);
	}
	
	public void visit(QuestionBody questionBody) {}
}
