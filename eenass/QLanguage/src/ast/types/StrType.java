package ast.types;

import ast.visitors.TypeVisitor;

public class StrType extends Type {
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return (this.isCompatibleToStr() && !type.isCompatibleToBool() && !type.isCompatibleToInt());
	}
	
	@Override
	public boolean isCompatibleToStr(){
		return true;
	}

}
