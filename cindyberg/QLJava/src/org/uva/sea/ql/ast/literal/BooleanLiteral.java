package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;


public class BooleanLiteral extends Literal<Boolean> {
	
	public boolean bool;

	public BooleanLiteral(boolean b) {
		super(b);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);		
	}


	public Type typeOf(TypeEnvironment environment) {
		return new BooleanType();
	}
	

}
