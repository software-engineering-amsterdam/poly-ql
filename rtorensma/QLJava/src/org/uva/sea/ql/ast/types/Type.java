package org.uva.sea.ql.ast.types;

public abstract class Type {
	
	public abstract boolean isCompatibleTo(Type t);
	
	public boolean isCompatibleToBool() { return false; }
	public boolean isCompatibleToInt() { return false; }
	public boolean isCompatibleToStr() { return false; }
}
