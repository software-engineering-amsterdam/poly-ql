package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.interpreter.value.Value;
import org.uva.sea.ql.interpreter.visitor.ITypeVisitor;

public class Int extends Number {

	@Override
	public Value<?> hasValue() {
		return new org.uva.sea.ql.interpreter.value.Int();
	}

	@Override
	public String toString() {
		return "integer";
	}

	@Override
	public <T> T accept(ITypeVisitor<T> tv) {
		return tv.visit(this);
	}

}
