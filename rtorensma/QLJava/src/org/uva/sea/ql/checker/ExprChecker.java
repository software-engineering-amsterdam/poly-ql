package org.uva.sea.ql.checker;

import java.util.List;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Bool;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.Int;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Str;
import org.uva.sea.ql.ast.expr.Sub;

public class ExprChecker implements ExprVisitor<Boolean> {
	
	private final List<String> errors;
	
	public ExprChecker(List<String> errors) {
		this.errors = errors;
	}
	
	public boolean check(Expr expr)
	{
		return expr.accept(this);
	}

	@Override
	public Boolean visit(Add expr) {
		return true;
	}

	@Override
	public Boolean visit(And expr) {
		return true;
	}

	@Override
	public Boolean visit(Bool expr) {
		return true;
	}

	@Override
	public Boolean visit(Div expr) {
		return true;
	}

	@Override
	public Boolean visit(Eq expr) {
		return true;
	}

	@Override
	public Boolean visit(GEq expr) {
		return true;
	}

	@Override
	public Boolean visit(GT expr) {
		return true;
	}

	@Override
	public Boolean visit(Ident expr) {
		return true;
	}

	@Override
	public Boolean visit(Int expr) {
		return true;
	}

	@Override
	public Boolean visit(LEq expr) {
		return true;
	}

	@Override
	public Boolean visit(LT expr) {
		return true;
	}

	@Override
	public Boolean visit(Mul expr) {
		return true;
	}

	@Override
	public Boolean visit(Neg expr) {
		return true;
	}

	@Override
	public Boolean visit(NEq expr) {
		return true;
	}

	@Override
	public Boolean visit(Not expr) {
		return true;
	}

	@Override
	public Boolean visit(Or expr) {
		return true;
	}

	@Override
	public Boolean visit(Pos expr) {
		return true;
	}

	@Override
	public Boolean visit(Sub expr) {
		return true;
	}

	@Override
	public Boolean visit(Str expr) {
		return true;
	}
	public List<String> getErrors() {
		return errors;
	}
}
