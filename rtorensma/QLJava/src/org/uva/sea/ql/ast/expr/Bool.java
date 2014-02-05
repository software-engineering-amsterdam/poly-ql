package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.checker.ExprVisitor;


public class Bool extends Expr {
	private final boolean value;
	
	public Bool(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
