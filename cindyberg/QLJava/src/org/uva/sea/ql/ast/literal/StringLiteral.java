package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.IVisitor;

public class StringLiteral extends Literal<String>{

	public StringLiteral(String name) {
		super(name);
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}

}
