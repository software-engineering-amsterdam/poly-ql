package visitor;

import java.util.List;

import nodeAST.Expression;
import nodeAST.Ident;
import nodeAST.arithmetic.Add;
import nodeAST.arithmetic.Div;
import nodeAST.arithmetic.Mul;
import nodeAST.arithmetic.Sub;
import nodeAST.conditional.And;
import nodeAST.conditional.Or;
import nodeAST.literals.Bool;
import nodeAST.literals.Int;
import nodeAST.literals.Str;
import nodeAST.relational.Eq;
import nodeAST.relational.GEq;
import nodeAST.relational.GT;
import nodeAST.relational.LEq;
import nodeAST.relational.LT;
import nodeAST.relational.NEq;
import nodeAST.syntactic.Form;
import nodeAST.syntactic.IfBlock;
import nodeAST.syntactic.IfElseBlock;
import nodeAST.syntactic.Question;
import nodeAST.syntactic.QuestionBody;
import nodeAST.syntactic.Statement;


import types.BoolType;
import types.IntType;
import types.StringType;
import types.Type;
import nodeAST.sign.Neg;
import nodeAST.sign.Not;
import nodeAST.sign.Pos;

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

	public void visit(StringType stringType) {	}

	public void visit(Str str) {}
}
