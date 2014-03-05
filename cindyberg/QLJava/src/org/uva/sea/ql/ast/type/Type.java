package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.IVisitor;


public abstract class Type extends ASTNode {
	
	public abstract void accept(IVisitor visitor);
	//is the visitor necessary ??
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
