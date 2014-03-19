package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.gui.TypeVisitor;

public class Str extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}

	@Override
	public boolean isCompatibleToStr() {
		return true;
	}
	
	@Override
	public String toString() {
		return "string";
	}
	
	@Override
	public <T,U> T accept(TypeVisitor<T,U> visitor, U arg) {
		return visitor.visit(this, arg);
	}
}
