package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.expr.*;

public interface ExprVisitor<T> {
	
	public T visit(Add ex);
	public T visit(Sub ex);
	public T visit(Mul ex);
	public T visit(Div ex);

	public T visit(And ex);
	public T visit(Or ex);

	public T visit(LEq ex);
	public T visit(LT ex);
	public T visit(NEq ex);
	public T visit(Eq ex);
	public T visit(GT ex);
	public T visit(GEq ex);

	public T visit(Pos ex);
	public T visit(Neg ex);
	public T visit(Not ex);
	
	public T visit(Str ex);
	public T visit(Bool ex);
	public T visit(Int ex);
	public T visit(Decimal ex);
	public T visit(Money ex);
	public T visit(Ident ex);
}
