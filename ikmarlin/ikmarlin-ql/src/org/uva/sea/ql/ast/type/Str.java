package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.interpreter.value.Value;
import org.uva.sea.ql.interpreter.visitor.ITypeVisitor;


public class Str extends Type {
	
	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithStr();
	}

	@Override
	public boolean isCompatibleWithStr() {
		return true;
	}

	@Override
	public Value<?> hasValue() {
		return new org.uva.sea.ql.interpreter.value.Str();
	}

	@Override
	public String toString() {
		return "string";
	}

	@Override
	public <T> T accept(ITypeVisitor<T> tv) {
		return tv.visit(this);
	}

}
