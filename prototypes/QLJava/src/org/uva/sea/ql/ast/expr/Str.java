package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;

public class Str extends Expr {
	private final String value;

	public Str(String value) {
		this.value = value.substring(1, value.length() - 1);
	}
	
	public String getValue() {
		return value;
	}
	

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.Str();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
