package ql.ast.operators;

import ql.ast.expressions.ExprInterface;

public abstract class BinOp implements OInterface {
	private final ExprInterface left;
	private final ExprInterface right;
	
	public BinOp(ExprInterface left, ExprInterface right) {
		this.left = left;
		this.right = right;
	}

	public ExprInterface getLeft() {
		return this.left;
	}
	
	public ExprInterface getRight() {
		return this.right;
	}
	
}
