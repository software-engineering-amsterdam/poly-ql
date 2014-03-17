package org.uva.sea.ql.ast.types;

public class Int extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}
	
	@Override
	public String toString() {
		return "integer";
	}
}
