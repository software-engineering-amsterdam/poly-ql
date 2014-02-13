package org.uva.sea.ql.ast.type;

public class IntType extends Type{


	public void accept(ITypeVisitor visitor) {
		visitor.visit(this);
		
	}

}
