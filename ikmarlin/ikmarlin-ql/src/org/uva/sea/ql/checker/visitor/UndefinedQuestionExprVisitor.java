package org.uva.sea.ql.checker.visitor;

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

public class UndefinedQuestionExprVisitor implements IExprVisitor<Ident> {

	@Override
	public Ident visit(Ident ex) {
		return ex;
	}

	private Ident visitBinaryExpr(Binary ex){
		return null;
	}

	private Ident visitUnaryExpr(Unary ex){
		return null;
	}

	private Ident visitLiteral(Literal<?> ex){
		return null;
	}

	@Override
	public Ident visit(Add ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(Sub ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(Mul ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(Div ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(And ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(Or ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(LEq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(LT ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(NEq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(Eq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(GT ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(GEq ex) {
		return visitBinaryExpr(ex);
	}

	@Override
	public Ident visit(Pos ex) {
		return visitUnaryExpr(ex);
	}

	@Override
	public Ident visit(Neg ex) {
		return visitUnaryExpr(ex);
	}

	@Override
	public Ident visit(Not ex) {
		return visitUnaryExpr(ex);
	}

	@Override
	public Ident visit(BoolLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public Ident visit(StrLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public Ident visit(DecimalLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public Ident visit(IntLiteral ex) {
		return visitLiteral(ex);
	}

	@Override
	public Ident visit(MoneyLiteral ex) {
		return visitLiteral(ex);
	}
	
}