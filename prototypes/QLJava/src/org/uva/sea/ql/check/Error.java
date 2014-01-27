package org.uva.sea.ql.check;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.Visitor;

public class Error extends Type {
	@Override
	public boolean isError() {
		return true;
	}
	
	@Override
	public String toString() {
		return "<error>";
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	@Override
	public <T, U> T accept(Visitor<T, U> visitor, U arg) {
		return visitor.visit(this, arg);
	}
}
