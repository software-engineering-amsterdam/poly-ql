package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.IVisitor;

public class IntType extends Type{


	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}
	
	public String show(){
		return "int";
	}
	
	@Override
	public boolean isCompatibleWithNumeric(){
		return true;
	}

}
