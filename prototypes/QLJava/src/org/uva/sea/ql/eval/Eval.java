package org.uva.sea.ql.eval;

import java.util.Map;

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
import org.uva.sea.ql.ast.expr.Visitor;

public class Eval implements Visitor<Value> {
	
	private final Map<Ident, Value> env;

	public Eval(Map<Ident, Value> env) {
		this.env = env;
	}

	
	@Override
	public Value visit(Add exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.add(r);
	}

	@Override
	public Value visit(And exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.and(r);
	}

	@Override
	public Value visit(Div exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.div(r);
	}

	@Override
	public Value visit(Eq exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.eq(r);
	}

	@Override
	public Value visit(GEq exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.geq(r);
	}

	@Override
	public Value visit(GT exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.gt(r);
	}

	@Override
	public Value visit(Ident var) {
		if (env.containsKey(var)) {
			return env.get(var);
		}
		return Undefined.UNDEF;
	}

	@Override
	public Value visit(Int exp) {
		return new org.uva.sea.ql.eval.Int(exp.getValue());
	}

	@Override
	public Value visit(LEq exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.leq(r);	}

	@Override
	public Value visit(LT exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.lt(r);	}

	@Override
	public Value visit(Mul exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.mul(r);
	}

	@Override
	public Value visit(Neg exp) {
		Value a = exp.getArg().accept(this);
		return a.neg();
	}

	@Override
	public Value visit(NEq exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.neq(r);
	}

	@Override
	public Value visit(Not exp) {
		Value a = exp.getArg().accept(this);
		return a.not();
	}

	@Override
	public Value visit(Or exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.or(r);
	}

	@Override
	public Value visit(Pos exp) {
		Value a = exp.getArg().accept(this);
		return a.pos();
	}

	@Override
	public Value visit(Sub exp) {
		Value l = exp.getLhs().accept(this);
		Value r = exp.getRhs().accept(this);
		return l.sub(r);
	}

	@Override
	public Value visit(Bool bool) {
		return new org.uva.sea.ql.eval.Bool(bool.getValue());
	}

	@Override
	public Value visit(Str str) {
		return new org.uva.sea.ql.eval.Str(str.getValue());
	}

}
