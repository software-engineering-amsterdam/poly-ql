package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Type;

public class Not extends Unary {

	public Not(Expr arg) {
		super(arg);
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
