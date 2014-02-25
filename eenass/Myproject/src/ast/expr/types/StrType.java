package ast.expr.types;

import ast.Visitor;

public class StrType extends Types {
	
	private String val;

	public String getVal() {
		return val;		
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatableTo(Types type) {
		return this.isCompatableToStr();
	}
	
	@Override
	public boolean isCompatableToStr(){
		return true;
	}

	@Override
	public String show() {
		return "string";
	}

}
