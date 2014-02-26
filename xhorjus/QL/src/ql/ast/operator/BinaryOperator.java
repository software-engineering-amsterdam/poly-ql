package ql.ast.operator;

import ql.ast.expression.*;

/** 
 * Binary operator abstract class. Has two expressions, to the left and to the right.
 */
public abstract class BinaryOperator implements OperatorInterface {
	ExpressionInterface left;
	ExpressionInterface right;
	
	public BinaryOperator(ExpressionInterface left, ExpressionInterface right) {
		this.left = left;
		this.right = right;
	}
}