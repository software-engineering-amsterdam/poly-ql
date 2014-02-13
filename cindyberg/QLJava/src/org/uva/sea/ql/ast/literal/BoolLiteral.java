package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.operators.IOperatorVisitor;

public class BoolLiteral extends Literal<Boolean> {
	
	public boolean bool;

	public BoolLiteral(boolean b) {
		super(b);
	}

	@Override
	public void accept(IOperatorVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
	

}
