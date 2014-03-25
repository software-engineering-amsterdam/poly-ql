package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.gui.inputs.TypeVisitor;

public abstract class Type {
	public abstract boolean isCompatibleTo(Type t);
	
	public boolean isCompatibleToBool() { return false; }
	public boolean isCompatibleToInt() { return false; }
	public boolean isCompatibleToStr() { return false; }
	
	public abstract <T,U> T accept(TypeVisitor<T,U> visitor, U arg);
}
