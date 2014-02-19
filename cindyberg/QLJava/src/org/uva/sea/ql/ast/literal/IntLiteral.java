package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.typechecker.Environment;


public class IntLiteral extends Literal<Integer> {
	
	public IntLiteral(int n) {
		super(n);
	}

	@Override
	public <T> void accept(ExpressionVisitor<T> visitor) {
		visitor.visit(this);
		
	}

	@Override
	public Type typeOf() {
		return new IntType();
	}

}
