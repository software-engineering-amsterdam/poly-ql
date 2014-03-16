package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.checker.ExprVisitor;
import org.uva.sea.ql.checker.TypeEnvironment;


public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnv) {
		return typeEnv.getTypeOfIdent(this);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ident)) {
			return false;
		}
		return name.equals(((Ident)obj).name);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
