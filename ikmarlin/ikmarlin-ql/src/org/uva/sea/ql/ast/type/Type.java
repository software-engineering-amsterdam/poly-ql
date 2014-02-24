package org.uva.sea.ql.ast.type;

public abstract class Type {
	public boolean isCompatibleWith(Bool t) {
		return false;
	}
	
	public boolean isCompatibleWith(Str t) {
		return false;
	}
	
	public boolean isCompatibleWith(Number t) {
		return false;
	}
	
	public boolean isCompatibleWith(Undefined t) {
		return false;
	}
}
