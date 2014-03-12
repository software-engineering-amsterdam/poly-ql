package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.TypeVisitor;

public class BooleanType extends Type{

	public String toString(){
		return "boolean";
	}

	
	public boolean isCompatibleWithBoolean() {
		return true;
	}
	
	public boolean isCompatibleWith(Type t){
		return t.isCompatibleWithBoolean();
	}


	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
