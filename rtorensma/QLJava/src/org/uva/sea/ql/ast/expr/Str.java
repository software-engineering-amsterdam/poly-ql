package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.checker.ExprVisitor;
import org.uva.sea.ql.checker.TypeEnvironment;


public class Str extends Expr {
	private final String value;

	public Str(String value) {
		this.value = value.substring(1, value.length() - 1);
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnv) {
		return new org.uva.sea.ql.ast.types.Str();
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
