package ast.expr.types;

import ast.Visitor;

public class BoolType extends Types {
	
	private boolean val;

	public boolean isVal() {
		return val;
	}
	
	public void setVal(boolean val){
		this.setKnown();
		this.val = val;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatableTo(Types type) {
		return type.isCompatableToBool();
	}
	
	@Override
	public boolean isCompatableToBool(){
		return true;
	}

}
