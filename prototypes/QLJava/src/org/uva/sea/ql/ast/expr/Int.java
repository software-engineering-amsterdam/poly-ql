package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;

public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.Int();
	}
	
}
