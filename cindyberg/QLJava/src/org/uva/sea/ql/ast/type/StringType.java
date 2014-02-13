package org.uva.sea.ql.ast.type;


public class StringType extends Type{

	public void accept(ITypeVisitor visitor) {
		visitor.visit(this);
		
	}

}
