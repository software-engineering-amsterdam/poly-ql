package org.uva.sea.ql.ast.expr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.uva.sea.ql.checker.ExprVisitor;

public class UsedVariables implements ExprVisitor<List<Ident>> {
	public static List<Ident> usedVariables(Expr expr) {
		UsedVariables usedVars = new UsedVariables();
		return expr.accept(usedVars);
	}
	
	@Override
	public List<Ident> visit(Add expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(And expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(Bool expr) {
		return new ArrayList<Ident>();
	}

	@Override
	public List<Ident> visit(Div expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(Eq expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(GEq expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(GT expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(Ident expr) {
		return Arrays.asList(new Ident[] {expr});
	}

	@Override
	public List<Ident> visit(Int expr) {
		return new ArrayList<Ident>();
	}

	@Override
	public List<Ident> visit(LEq expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(LT expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(Mul expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(Neg expr) {
		return expr.accept(this);
	}

	@Override
	public List<Ident> visit(NEq expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(Not expr) {
		return expr.accept(this);
	}

	@Override
	public List<Ident> visit(Or expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(Pos expr) {
		return expr.accept(this);
	}

	@Override
	public List<Ident> visit(Sub expr) {
		return visitBinaryExpr(expr);
	}

	@Override
	public List<Ident> visit(Str expr) {
		return new ArrayList<Ident>();
	}
	
	private List<Ident> visitBinaryExpr(BinaryExpr expr) {
		return ListUtils.union(expr.getLhs().accept(this), expr.getRhs().accept(this));
	}
}
