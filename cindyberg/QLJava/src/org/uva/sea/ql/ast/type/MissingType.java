package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.TypeVisitor;

public class MissingType extends Type {
	


	@Override
	public String toString() {
		return "Missing Type";
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatibleWith(Type typeOf) {
		return false;
	}

}
