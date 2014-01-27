package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;

public class Add extends Binary {

	public Add(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Numeric();
	}

}
