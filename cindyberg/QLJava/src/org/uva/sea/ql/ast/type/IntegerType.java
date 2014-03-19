package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.TypeVisitor;

public class IntegerType extends Type{
	
	public String toString(){
		return "integer";
	}
	
	@Override
	public boolean isCompatibleWithInteger(){
		return true;
	}
	
	@Override
	public boolean isCompatibleWith(Type t){
		return t.isCompatibleWithInteger();
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	

}
