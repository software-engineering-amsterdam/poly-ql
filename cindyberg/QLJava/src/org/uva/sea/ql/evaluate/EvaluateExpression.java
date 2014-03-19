package org.uva.sea.ql.evaluate;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.BooleanLiteral;
import org.uva.sea.ql.ast.literal.IntegerLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.operators.arithmetic.Add;
import org.uva.sea.ql.ast.operators.arithmetic.Div;
import org.uva.sea.ql.ast.operators.arithmetic.Mul;
import org.uva.sea.ql.ast.operators.arithmetic.Neg;
import org.uva.sea.ql.ast.operators.arithmetic.Pos;
import org.uva.sea.ql.ast.operators.arithmetic.Sub;
import org.uva.sea.ql.ast.operators.comparison.Eq;
import org.uva.sea.ql.ast.operators.comparison.GEq;
import org.uva.sea.ql.ast.operators.comparison.GT;
import org.uva.sea.ql.ast.operators.comparison.LEq;
import org.uva.sea.ql.ast.operators.comparison.LT;
import org.uva.sea.ql.ast.operators.comparison.NEq;
import org.uva.sea.ql.ast.operators.logical.And;
import org.uva.sea.ql.ast.operators.logical.Not;
import org.uva.sea.ql.ast.operators.logical.Or;

public class EvaluateExpression implements ExpressionVisitor<Value>{
	
	private VariableEnvironment environment;
	
	public EvaluateExpression(VariableEnvironment environment){
		this.environment = environment;
	}

	public Value visit(Add ast) {
		return ast.getLeftHand().accept(this).add(
				ast.getRightHand().accept(this));
	}

	public Value visit(Sub ast) {
		return ast.getLeftHand().accept(this).sub(
				ast.getRightHand().accept(this));
	}

	public Value visit(Div ast) {
		return ast.getLeftHand().accept(this).div(
				ast.getRightHand().accept(this));
	}

	public Value visit(Mul ast) {
		return ast.getLeftHand().accept(this).mul(
				ast.getRightHand().accept(this));
	}

	public Value visit(Neg ast) {
		return ast.getExpr().accept(this).neg();
	}

	public Value visit(Pos ast) {
		return ast.getExpr().accept(this).pos();
	}

	public Value visit(Eq ast) {
		return ast.getLeftHand().accept(this).eq(
				ast.getRightHand().accept(this));	
	}

	public Value visit(GEq ast) {
		return ast.getLeftHand().accept(this).geq(
				ast.getRightHand().accept(this));
	}

	public Value visit(GT ast) {
		return ast.getLeftHand().accept(this).gt(
				ast.getRightHand().accept(this));
	}

	public Value visit(LEq ast) {
		return ast.getLeftHand().accept(this).leq(
				ast.getRightHand().accept(this));
	}

	public Value visit(LT ast) {
		return ast.getLeftHand().accept(this).lt(
				ast.getRightHand().accept(this));
	}

	public Value visit(NEq ast) {
		return ast.getLeftHand().accept(this).neq(
				ast.getRightHand().accept(this));
	}

	public Value visit(And ast) {
		return ast.getLeftHand().accept(this).and(
				ast.getRightHand().accept(this));
	}

	public Value visit(Or ast) {
		return ast.getLeftHand().accept(this).or(
				ast.getRightHand().accept(this));
	}

	public Value visit(Not ast) {
		return ast.getExpr().accept(this).not();
	}

	public Value visit(IntegerLiteral intLiteral) {
		return new IntegerValue(intLiteral.getLiteral());
	}

	public Value visit(BooleanLiteral boolLiteral) {
		return new BooleanValue(boolLiteral.getLiteral());
	}

	public Value visit(StringLiteral stringLiteral) {
		return new StringValue(stringLiteral.getLiteral());
	}

	public Value visit(Identifier identifier) {
		if(environment.isDeclared(identifier)){
			return environment.getValue(identifier);
		}
	    return new UndefinedValue();
	}

}
