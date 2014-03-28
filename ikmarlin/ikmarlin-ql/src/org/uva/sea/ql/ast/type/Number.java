package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.interpreter.value.Value;
import org.uva.sea.ql.interpreter.visitor.ITypeVisitor;


public class Number extends Type {
	
	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithNumber();
	}

	@Override
	public boolean isCompatibleWithNumber() {
		return true;
	}

	@Override
	public Value<?> hasValue() {
		return null;
	}

	@Override
	public String toString() {
		return "number";
	}

	@Override
	public <T> T accept(ITypeVisitor<T> tv) {
		return null;
	}


}
