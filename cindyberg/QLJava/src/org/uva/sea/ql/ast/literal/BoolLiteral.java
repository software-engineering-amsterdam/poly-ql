package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.Environment;


public class BoolLiteral extends Literal<Boolean> {
	
	public boolean bool;

	public BoolLiteral(boolean b) {
		super(b);
	}


	@Override
	public <T> void accept(ExpressionVisitor<T> visitor) {
		visitor.visit(this);
		
	}


	@Override
	public Type typeOf() {
		return new BoolType();
	}
	

}
