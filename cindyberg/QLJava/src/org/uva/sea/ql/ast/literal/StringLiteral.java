package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;

public class StringLiteral extends Literal<String>{

	public StringLiteral(String name) {
		super(name);
	}

	@Override
	public Type typeOf(TypeEnvironment environment) {
		return new StringType();
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
		
	}
}
