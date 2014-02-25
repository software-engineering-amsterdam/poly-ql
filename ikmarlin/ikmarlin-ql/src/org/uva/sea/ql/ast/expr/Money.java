package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.ExprVisitor;

public class Money extends Number {
	private float value;
	
	public Money(float value) {
		this.setValue(value);
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public Type hasType() {
		return new org.uva.sea.ql.ast.type.Money();
	}
	
	@Override
	public <T> T accept(ExprVisitor<T> ev){
		return ev.visit(this);
	}

	@Override
	public String toString() {
		return "money";
	}

}
