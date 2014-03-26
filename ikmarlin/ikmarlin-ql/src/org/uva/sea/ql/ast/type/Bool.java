package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.interpreter.value.Value;
import org.uva.sea.ql.interpreter.visitor.ITypeVisitor;

public class Bool extends Type {
	
	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithBool();
	}

	@Override
	public boolean isCompatibleWithBool() {
		return true;
	}

	@Override
	public Value<?> hasValue() {
		return new org.uva.sea.ql.interpreter.value.Bool();
	}

	@Override
	public String toString() {
		return "boolean";
	}

	@Override
	public <T> T accept(ITypeVisitor<T> tv) {
		return tv.visit(this);
	}

}
