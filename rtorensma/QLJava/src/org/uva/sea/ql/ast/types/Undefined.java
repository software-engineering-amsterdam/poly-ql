package org.uva.sea.ql.ast.types;

public class Undefined extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
	
	@Override
	public String toString() {
		return "undefined";
	}
}
