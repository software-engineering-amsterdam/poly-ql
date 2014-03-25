package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.gui.inputs.TypeVisitor;

public class Undefined extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
	
	@Override
	public String toString() {
		return "undefined";
	}
	
	@Override
	public <T,U> T accept(TypeVisitor<T,U> visitor, U arg) {
		return visitor.visit(this, arg);
	}
}
