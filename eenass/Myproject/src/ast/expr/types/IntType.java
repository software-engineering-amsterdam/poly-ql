package ast.expr.types;

import ast.Visitor;

public class IntType extends Type{

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return this.isCompatibleToInt();
	}
	
	@Override
	public boolean isCompatibleToInt(){
		return true;
	}

	@Override
	public String show() {
		return "integer";
	}

}
