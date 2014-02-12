package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.operators.IOperatorVisitor;

public class StringLiteral extends Literal<String>{

	public StringLiteral(String name) {
		super(name);
	}

	@Override
	public void accept(IOperatorVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
