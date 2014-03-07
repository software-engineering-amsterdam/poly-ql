package ql.ast.operator;

import ql.ast.expression.ExpressionInterface;
import ql.ast.type.TypeMoney;

/**
 * Parent class for arithmetic operators
 */
public abstract class OperatorArithmetic extends BinaryOperator {
	public OperatorArithmetic(ExpressionInterface left, ExpressionInterface right) {
		super(left, right);
	}
	
	@Override public TypeMoney getType() { 
		return new TypeMoney();
	}
}