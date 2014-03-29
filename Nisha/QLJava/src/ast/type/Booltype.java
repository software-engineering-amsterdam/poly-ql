package ast.type;

import ast.Visitor;

public class Booltype extends Type {

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean istype(Type type) {
		return (type.isBool() && !type.isInt() && !type.isStr());
	}
	
	public boolean isBool() {
		return true;
	}
	
	}
	
