package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.IVisitor;


public class MoneyType extends Type{

	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}
	
	public String toString(){
		return "money";
	}
	
	
	public boolean isCompatibleWith(Type t){
		return t.isCompatibleWithInteger(); //TODO what id t is also money? I think is going to return false
	}

}
