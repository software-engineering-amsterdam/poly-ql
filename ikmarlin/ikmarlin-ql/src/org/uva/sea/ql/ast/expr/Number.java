package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.ExprVisitor;

public abstract class Number extends ExprType {

	@Override
	public abstract Type hasType();

	@Override
	public abstract <T> T accept(ExprVisitor<T> ev);

	@Override
	public abstract String toString();
}
