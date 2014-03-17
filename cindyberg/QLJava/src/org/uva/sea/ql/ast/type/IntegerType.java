package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.TypeVisitor;

public class IntegerType extends Type{
	
	public String toString(){
		return "int";
	}
	
	@Override
	public boolean isCompatibleWithInteger(){
		return true;
	}
	
	public boolean isCompatibleWith(Type t){
		return t.isCompatibleWithInteger();
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	

}
