package ast.expr.types;

import ast.Visitor;

public class IntType extends Types{

	private int val;
	
	public int geVal(){
		return val;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatableTo(Types type) {
		return this.isCompatableToInt();
	}
	
	@Override
	public boolean isCompatableToInt(){
		return true;
	}

}
