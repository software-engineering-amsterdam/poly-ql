package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.ExprVisitor;

public class Str extends ExprType {
	private String value;
	
	public Str(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Type hasType() {
		return new org.uva.sea.ql.ast.type.Str();
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
