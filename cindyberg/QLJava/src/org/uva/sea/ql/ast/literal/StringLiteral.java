package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.typechecker.Environment;

public class StringLiteral extends Literal<String>{

	public StringLiteral(String name) {
		super(name);
	}

	@Override
	public Type typeOf() {
		return new StringType();
	}

	@Override
	public <T> void accept(ExpressionVisitor<T> visitor) {
		visitor.visit(this);
		
	}

}
