package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.IVisitor;


public class StringType extends Type{

	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}
	
	public String show(){
		return "string";
	}

}
