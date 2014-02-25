package ql.ast.operator;

import ql.ast.expression.*;

public abstract class BinaryOperator implements OperatorInterface {
	ExpressionInterface left;
	ExpressionInterface right;
	
	public BinaryOperator(ExpressionInterface left, ExpressionInterface right) {
		this.left = left;
		this.right = right;
	}
}