package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.TypeVisitor;


public class MoneyType extends Type{
	
	public String toString(){
		return "money";
	}
	
	
	public boolean isCompatibleWith(Type t){
		return t.isCompatibleWithInteger(); //TODO what id t is also money? I think is going to return false
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
