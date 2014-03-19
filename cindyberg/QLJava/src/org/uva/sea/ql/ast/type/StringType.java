package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.TypeVisitor;


public class StringType extends Type{

	public void accept(IVisitor visitor) {
		visitor.visit(this);		
	}
	
	@Override
	public String toString(){
		return "string";
	}
	
	@Override
	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithString();
	}
	
	@Override
	public boolean isCompatibleWithString(){
		return true;
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
