package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.Expression;


public abstract class Literal<T> extends Expression {

	protected T value;
	
	public Literal(T n) {
		this.value = n;
	}	
	
	public T getLiteral(){
		return this.value;
	}
	
	public String toString(){
		return value.toString();
	}
	
	@Override
	public boolean equals(Object other) {
	    if (other instanceof Literal) {
	        return value.equals(((Literal<?>) other).value);
	    } 
	    return false;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}

}
