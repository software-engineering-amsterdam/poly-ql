package org.uva.sea.ql.ast.type;

public class Bool extends Type {
	
	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithBool();
	}

	@Override
	public boolean isCompatibleWithBool() {
		return true;
	}

	@Override
	public String toString() {
		return "boolean";
	}

}
