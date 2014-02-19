package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.Expression;


public abstract class Literal<T> extends Expression {

	private T value;
	
	public Literal(T n) {
		this.value = n;
	}	
	
	public T getLiteral(){
		return this.value;
	}
	
	public String show(){
		return value.toString();
	}

}
