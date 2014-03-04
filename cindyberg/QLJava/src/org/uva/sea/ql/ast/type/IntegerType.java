package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.IVisitor;

public class IntegerType extends Type{


	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}
	
	public String show(){
		return "int";
	}
	
	@Override
	public boolean isCompatibleWithInteger(){
		return true;
	}
	
	public boolean isCompatibleWith(Type t){
		return t.isCompatibleWithInteger();
	}
	

}
