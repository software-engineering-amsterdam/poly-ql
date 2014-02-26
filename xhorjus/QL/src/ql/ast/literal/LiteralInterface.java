package ql.ast.literal;

import ql.ast.expression.ExpressionInterface;

public abstract class LiteralInterface<T> implements ExpressionInterface {
	private T lit;
	
	public LiteralInterface(T lit) {
		this.lit = lit;
	}
	
	public T getLit() {
		return this.lit;
	}
}