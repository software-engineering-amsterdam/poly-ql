package ql.ast.operator;

import ql.ast.expression.ExpressionInterface;
import ql.ast.type.TypeBool;

/**
 * Parent class for conditional operators
 */
public abstract class OperatorConditional extends BinaryOperator {
	public OperatorConditional(ExpressionInterface left, ExpressionInterface right) {
		super(left, right);
	}
	
	@Override public TypeBool getType() { 
		return new TypeBool();
	}
}