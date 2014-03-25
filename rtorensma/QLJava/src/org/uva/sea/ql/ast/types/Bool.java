package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.gui.inputs.TypeVisitor;

public class Bool extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() {
		return true;
	}
	
	@Override
	public String toString() {
		return "boolean";
	}
	
	@Override
	public <T,U> T accept(TypeVisitor<T,U> visitor, U arg) {
		return visitor.visit(this, arg);
	}
}
