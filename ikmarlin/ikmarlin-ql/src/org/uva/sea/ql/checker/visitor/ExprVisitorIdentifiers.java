package org.uva.sea.ql.checker.visitor;

import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Binary;
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
import org.uva.sea.ql.ast.expr.Literal;
import org.uva.sea.ql.ast.expr.MoneyLiteral;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StrLiteral;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.Unary;

public class ExprVisitorIdentifiers implements IExprVisitor<Set<Ident>> {

	private Set<Ident> variables;

	public ExprVisitorIdentifiers() {
		variables = new HashSet<Ident>();
	}

	private Set<Ident> visitBinaryExpr(Binary ex) {
		ex.getLhs().accept(this);
		ex.getRhs().accept(this);
		return variables;
	}

	private Set<Ident> visitUnaryExpr(Unary ex) {
		ex.getArg().accept(this);
		return variables;
	}

	private Set<Ident> visitLiteral(Literal<?> ex) {
		return null;
	}

	@Override
	public Set<Ident> visit(Ident ex) {
		variables.add(ex);
		return variables;
	}

	@Override
	public Set<Ident> visit(Add ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(Sub ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(Mul ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(Div ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(And ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(Or ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(LEq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(LT ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(NEq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(Eq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(GT ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(GEq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(Pos ex) {
		return visitUnaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(Neg ex) {
		return visitUnaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(Not ex) {
		return visitUnaryExpr(ex);
	}

	@Override
	public Set<Ident> visit(BoolLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public Set<Ident> visit(StrLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public Set<Ident> visit(DecimalLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public Set<Ident> visit(IntLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public Set<Ident> visit(MoneyLiteral ex) {
		return visitLiteral(ex);
	}

}
