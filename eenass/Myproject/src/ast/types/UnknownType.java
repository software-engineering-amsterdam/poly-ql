package ast.types;

import ast.Visitor;

public class UnknownType extends Type{

	public UnknownType() {
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return false;
	}
	
	public String toString(){
		return "Unknown";
	}

}
