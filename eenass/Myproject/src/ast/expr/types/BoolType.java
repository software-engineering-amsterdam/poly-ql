package ast.expr.types;

import ast.Visitor;

public class BoolType extends Type {

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return (type.isCompatibleToBool() && !type.isCompatibleToInt() && !type.isCompatibleToStr());
	}
	
	@Override
	public boolean isCompatibleToBool(){
		return true;
	}

}
