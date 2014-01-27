package org.uva.sea.ql.ast.types;

public class Int extends Numeric {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Int;
	}
	
	@Override
	public String toString() {
		return "integer";
	}
	
	public <T, U> T accept(Visitor<T,U> visitor, U arg) {
		return visitor.visit(this, arg);
	}
}
