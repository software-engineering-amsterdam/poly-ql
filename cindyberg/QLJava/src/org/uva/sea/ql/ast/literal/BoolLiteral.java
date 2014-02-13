package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.IVisitor;


public class BoolLiteral extends Literal<Boolean> {
	
	public boolean bool;

	public BoolLiteral(boolean b) {
		super(b);
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
		
	}
	

}
