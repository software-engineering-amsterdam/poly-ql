package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.interpreter.value.Value;
import org.uva.sea.ql.interpreter.visitor.ITypeVisitable;

public abstract class Type implements ITypeVisitable {
	
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
	
	public boolean isCompatibleWithNull(){
		return false;
	}
	
	public abstract Value<?> hasValue();
	
	@Override
	public abstract String toString();

}
