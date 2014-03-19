package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.TypeVisitor;


public abstract class Type extends ASTNode {
	
	public abstract <T> T accept(TypeVisitor<T> visitor);
	
	public abstract String toString();
	
	public boolean isCompatibleWithBoolean(){
		return false;
	}
	
	public boolean isCompatibleWithString(){
		return false;
	}
	
	public boolean isCompatibleWithInteger() {
		return false;
	}
	
	public boolean isCompatibleWithMoney(){
		return false;
	}
	
	public abstract boolean isCompatibleWith(Type typeOf);
	
	@Override
	public boolean equals(Object other) {
	    if (other instanceof Type) {
	        return toString().equals(((Type) other).toString());
	    } 
	    return false;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
}
