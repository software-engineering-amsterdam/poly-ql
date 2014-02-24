package org.uva.sea.ql.ast.type;

public class Undefined extends Type {
	
	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithUndefined();
	}

	@Override
	public String toString() {
		return "undefined";
	}

}
