package org.uva.sea.ql.checker.visitor;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.DecimalLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.IntLiteral;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.MoneyLiteral;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StrLiteral;
import org.uva.sea.ql.ast.expr.Sub;

public interface IExprVisitor<T> {
	
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
	
	public T visit(Ident ex);
	
	public T visit(BoolLiteral ex);
	public T visit(StrLiteral ex);
	public T visit(DecimalLiteral ex);
	public T visit(IntLiteral ex);
	public T visit(MoneyLiteral ex);
}
