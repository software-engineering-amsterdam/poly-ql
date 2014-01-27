package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Type;

public class LEq extends Binary {

	public LEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new Bool();
	}

}
