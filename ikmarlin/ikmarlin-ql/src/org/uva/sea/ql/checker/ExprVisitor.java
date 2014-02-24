package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.expr.*;

public interface ExprVisitor {
	
	public void visit(Add ex);
	public void visit(Sub ex);
	public void visit(Mul ex);
	public void visit(Div ex);

	public void visit(And ex);
	public void visit(Or ex);

	public void visit(LEq ex);
	public void visit(LT ex);
	public void visit(NEq ex);
	public void visit(Eq ex);
	public void visit(GT ex);
	public void visit(GEq ex);

	public void visit(Pos ex);
	public void visit(Neg ex);
	public void visit(Not ex);
	
	public void visit(Str ex);
	public void visit(Bool ex);
	public void visit(Int ex);
	public void visit(Decimal ex);
	public void visit(Money ex);
	public void visit(Ident ex);
}
