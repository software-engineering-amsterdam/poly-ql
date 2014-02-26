package org.uva.sea.ql.ast.type;

public class Number extends Type {
	
	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithNumber();
	}

	@Override
	public boolean isCompatibleWithNumber() {
		return true;
	}

	@Override
	public String toString() {
		return "number";
	}

}
