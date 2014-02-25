package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.ExprVisitor;

public class Int extends Number {
	private int value;
	
	public Int(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public Type hasType() {
		return new org.uva.sea.ql.ast.type.Int();
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> ev){
		return ev.visit(this);
	}

	@Override
	public String toString() {
		return "integer";
	}

}
