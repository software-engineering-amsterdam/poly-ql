package org.uva.sea.ql.ast.type;

public class Null extends Type {
	
	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithNull();
	}

	@Override
	public String toString() {
		return "null";
	}

}
