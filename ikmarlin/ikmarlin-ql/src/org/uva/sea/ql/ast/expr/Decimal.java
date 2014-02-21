package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.ExprVisitor;

public class Decimal extends ExprType {
	private float value;
	
	public Decimal(float value) {
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
		return new org.uva.sea.ql.ast.type.Decimal();
	}
	
	@Override
	public void accept(ExprVisitor ev) {
		ev.visit(this);
	}
	
	@Override
	public String toString() {
		return String.valueOf(getValue());
	}

}
