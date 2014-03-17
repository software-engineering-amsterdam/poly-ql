package org.uva.sea.ql.eval;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Bool;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
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
import org.uva.sea.ql.checker.ExprVisitor;

public class Evaluator implements ExprVisitor<Value> {
	private final ValueEnvironment valueEnv;
	
	public Evaluator(ValueEnvironment env) {
		this.valueEnv = env;
	}

	@Override
	public Value visit(Add expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.add(r);
	}


	@Override
	public Value visit(And expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.and(r);
	}

	@Override
	public Value visit(Bool expr) {
		return new org.uva.sea.ql.eval.Bool(expr.getValue());
	}

	@Override
	public Value visit(Div expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.div(r);
	}

	@Override
	public Value visit(Eq expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.eq(r);
	}

	@Override
	public Value visit(GEq expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.geq(r);
	}

	@Override
	public Value visit(GT expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.gt(r);
	}

	@Override
	public Value visit(Ident expr) {
		if (this.valueEnv.isIdentDefined(expr)) {
			return this.valueEnv.getValueOfIdent(expr);
		}
		return new Undefined();
	}

	@Override
	public Value visit(Int expr) {
		return new org.uva.sea.ql.eval.Int(expr.getValue());
	}

	@Override
	public Value visit(LEq expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.leq(r);
	}

	@Override
	public Value visit(LT expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.lt(r);	}

	@Override
	public Value visit(Mul expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.mul(r);
	}

	@Override
	public Value visit(Neg expr) {
		Value a = expr.getExpr().accept(this);
		return a.neg();
	}

	@Override
	public Value visit(NEq expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.neq(r);
	}

	@Override
	public Value visit(Not expr) {
		Value a = expr.getExpr().accept(this);
		return a.not();
	}

	@Override
	public Value visit(Or expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.or(r);
	}

	@Override
	public Value visit(Pos expr) {
		Value a = expr.getExpr().accept(this);
		return a.pos();
	}

	@Override
	public Value visit(Sub expr) {
		Value l = expr.getLhs().accept(this);
		Value r = expr.getRhs().accept(this);
		return l.sub(r);
	}

	@Override
	public Value visit(Str expr) {
		return new org.uva.sea.ql.eval.Str(expr.getValue());
	}

	public ValueEnvironment getValueEnv() {
		return valueEnv;
	}
}
