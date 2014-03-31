package ast.types;

import ast.visitors.TypeVisitor;

public class UnknownType extends Type{

	public UnknownType() {
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
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
