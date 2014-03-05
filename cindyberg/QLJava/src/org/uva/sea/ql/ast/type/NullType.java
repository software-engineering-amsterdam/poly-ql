package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.IVisitor;

public class NullType extends Type {

	@Override
	public void accept(IVisitor visitor) {		
	}

	@Override
	public String toString() {
		return "No Type Available";
	}

	@Override
	public boolean isCompatibleWith(Type typeOf) {
		return false;
	}

}
