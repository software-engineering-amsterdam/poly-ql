package ast.types;

import ast.visitors.TypeVisitor;

public class IntType extends Type{

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return (this.isCompatibleToInt() && !type.isCompatibleToBool() && !type.isCompatibleToStr());
	}
	
	@Override
	public boolean isCompatibleToInt(){
		return true;
	}

}
