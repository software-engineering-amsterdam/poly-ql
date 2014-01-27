package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;

public class Bool extends Expr {
	private final Boolean value;
	
	public Bool(Boolean value) {
		this.value = value;
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.Bool();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public Boolean getValue() {
		return value;
	}
}
