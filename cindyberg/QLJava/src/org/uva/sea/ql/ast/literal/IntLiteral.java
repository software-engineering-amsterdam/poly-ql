package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.operators.IOperatorVisitor;


public class IntLiteral extends Literal<Integer> {
	
	public IntLiteral(int n) {
		super(n);
	}

	@Override
	public void accept(IOperatorVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
