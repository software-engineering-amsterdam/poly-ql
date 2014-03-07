package org.uva.sea.ql.ast.expr;


public abstract class Literal<T> extends Expr {
	
	private T value;
	
	public void setValue(T value){
		this.value = value;
	}
	
	public T getValue(){
		return value;
	}
	
	@Override
	public String toString(){
		return String.valueOf(value);
	}
	
}
