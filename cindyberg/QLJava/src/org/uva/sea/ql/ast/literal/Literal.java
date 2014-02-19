package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.Environment;


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
	
	public abstract Type typeOf();
	
}
