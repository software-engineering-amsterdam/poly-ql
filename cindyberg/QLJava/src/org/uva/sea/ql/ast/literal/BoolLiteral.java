package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;


public class BoolLiteral extends Literal<Boolean> {
	
	public boolean bool;

	public BoolLiteral(boolean b) {
		super(b);
	}


	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
		
	}


	public Type typeOf(TypeEnvironment environment) {
		return new BoolType();
	}
	

}
