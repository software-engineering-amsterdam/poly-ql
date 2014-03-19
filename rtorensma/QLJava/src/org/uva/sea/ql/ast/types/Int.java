package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.gui.TypeVisitor;

public class Int extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}
	
	@Override
	public String toString() {
		return "integer";
	}
	
	@Override
	public <T,U> T accept(TypeVisitor<T,U> visitor, U arg) {
		return visitor.visit(this, arg);
	}
}
