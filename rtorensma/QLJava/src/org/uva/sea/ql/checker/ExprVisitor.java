package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.expr.*;

public interface ExprVisitor<T> {
	
	T visit(Add expr);
	T visit(And expr);
	T visit(Bool expr);
	T visit(Div expr);
	T visit(Eq expr);
	T visit(GEq expr);
	T visit(GT expr);
	T visit(Ident expr);
	T visit(Int expr);
	T visit(LEq expr);
	T visit(LT expr);
	T visit(Mul expr);
	T visit(Neg expr);
	T visit(NEq expr);
	T visit(Not expr);
	T visit(Or expr);
	T visit(Pos expr);
	T visit(Sub expr);
	T visit(Str expr);
}
