package org.uva.sea.ql.ast.type;

public abstract class Type {
	
	public abstract boolean isCompatibleWith(Type t);

	public boolean isCompatibleWithBool(){
		return false;
	}
	
	public boolean isCompatibleWithStr() {
		return false;
	}
	
	public boolean isCompatibleWithNumber() {
		return false;
	}
	
	public boolean isCompatibleWithUndefined(){
		return true;
	}
	
	public boolean isCompatibleWithError(){
		return false;
	}
	
	@Override
	public abstract String toString();

}
