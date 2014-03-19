package ast.expr.types;

import ast.Visitor;

public class StrType extends Type {
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
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
