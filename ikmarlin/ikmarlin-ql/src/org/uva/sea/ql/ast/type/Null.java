package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.interpreter.value.Value;
import org.uva.sea.ql.interpreter.visitor.ITypeVisitor;

public class Null extends Type {
	
	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithNull();
	}

	@Override
	public Value<?> hasValue() {
		return new org.uva.sea.ql.interpreter.value.Undefined();
	}

	@Override
	public String toString() {
		return "null";
	}

	@Override
	public <T> T accept(ITypeVisitor<T> tv) {
		return tv.visit(this);
	}

}
