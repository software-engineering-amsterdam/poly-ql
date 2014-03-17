package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.checker.ExprVisitor;
import org.uva.sea.ql.checker.TypeEnvironment;

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
	
	@Override
	public Type typeOf(TypeEnvironment typeEnv) {
		return new org.uva.sea.ql.ast.types.Bool();
	}
	
	@Override
	public String toString() {
		return "" + this.value;
	}
}
