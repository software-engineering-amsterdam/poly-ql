package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.IVisitor;

public class MissingType extends Type {
	
	@Override
	public void accept(IVisitor visitor) {		
	}

	@Override
	public String toString() {
		return "Missing Type";
	}

	@Override
	public boolean isCompatibleWith(Type typeOf) {
		return false;
	}

}
