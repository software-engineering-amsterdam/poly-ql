package org.uva.sea.ql.ast.type;

public class Str extends Type {
	
	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithStr();
	}

	@Override
	public boolean isCompatibleWithStr() {
		return true;
	}

	@Override
	public String toString() {
		return "string";
	}

}
