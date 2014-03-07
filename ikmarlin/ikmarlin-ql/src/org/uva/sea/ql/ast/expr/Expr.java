package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.IExprVisitable;

public abstract class Expr implements IExprVisitable {
	
	public abstract Type hasType();
	
	@Override
	public abstract String toString();
	
}
