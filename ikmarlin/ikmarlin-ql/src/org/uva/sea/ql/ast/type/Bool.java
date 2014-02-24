package org.uva.sea.ql.ast.type;

public class Bool extends Type {
	
	@Override
	public boolean isCompatibleWith(Bool t) {
		return true;
	}

}
