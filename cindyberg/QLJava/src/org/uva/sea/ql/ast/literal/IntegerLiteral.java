package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;


public class IntegerLiteral extends Literal<Integer> {
	
	public IntegerLiteral(int n) {
		super(n);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(TypeEnvironment environment) {
		return new IntegerType();
	}

}
