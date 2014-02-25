package ql.ast.operators;

import ql.ast.expressions.ExprInterface;;

public abstract class UnOp implements OInterface {
	private final ExprInterface expression;
	
	public UnOp(ExprInterface expression) {
		this.expression = expression;
	}
	
	public ExprInterface getExpression() {
		return this.expression;
	}
}
