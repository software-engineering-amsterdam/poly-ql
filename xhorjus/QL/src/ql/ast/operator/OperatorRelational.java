package ql.ast.operator;

import ql.ast.expression.ExpressionInterface;
import ql.ast.type.TypeBool;

/**
 * Parent class for relational (EQ, NEQ, LT, GT, LTEQ, GTEQ) operators
 */
public abstract class OperatorRelational extends BinaryOperator {
	public OperatorRelational(ExpressionInterface left, ExpressionInterface right) {
		super(left, right);
	}
	
	@Override public TypeBool getType() { 
		return new TypeBool();
	}
}