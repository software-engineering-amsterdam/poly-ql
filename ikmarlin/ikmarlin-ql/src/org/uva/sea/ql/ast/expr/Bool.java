package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.ExprVisitor;

public class Bool extends ExprType {
	private boolean value;
	
	public Bool(boolean value) {
		this.setValue(value);
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	@Override
	public Type hasType() {
		return new org.uva.sea.ql.ast.type.Bool();
	}
	
	@Override
	public void accept(ExprVisitor ev) {
		ev.visit(this);
	}

	@Override
	public String toString() {
		return isValue()?"true":"false";
	}

}
