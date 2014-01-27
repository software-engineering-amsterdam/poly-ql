package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.check.Error;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if (typeEnv.containsKey(this)) {
			return typeEnv.get(this);
		}
		return new Error();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Ident)) {
			return false;
		}
		return getName().equals(((Ident)obj).getName());
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
