package org.uva.sea.ql.ast.types;

public abstract class Type {
	public boolean isError() {
		return false;
	}
	
	public abstract <T, U> T accept(Visitor<T, U> visitor, U arg);
	
	public abstract boolean isCompatibleTo(Type t);
	
	public boolean isCompatibleToInt() {
		return false;
	}

	public boolean isCompatibleToNumeric() {
		return false;
	}
	
	public boolean isCompatibleToStr() {
		return false;
	}
	
	public boolean isCompatibleToBool() {
		return false;
	}
	
	public boolean isCompatibleToMoney() {
		return false;
	}
}
