package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.IVisitor;


public class IntLiteral extends Literal<Integer> {
	
	public IntLiteral(int n) {
		super(n);
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}

}
