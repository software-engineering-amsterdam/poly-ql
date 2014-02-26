package ql.ast.operator;

import ql.ast.expression.*;

/**
 * Abstract class for unary operator with one expression
 */
public abstract class UnaryOperator implements OperatorInterface {
	ExpressionInterface expression;
	
	public UnaryOperator(ExpressionInterface expression) {
		this.expression = expression;
	}
}