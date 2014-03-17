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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(And expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Bool expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Div expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Eq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GT expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Ident expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Int expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LT expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Mul expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Neg expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(NEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Not expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Or expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Pos expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Sub expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Str expr) {
		// TODO Auto-generated method stub
		return null;
	}

	public ValueEnvironment getValueEnv() {
		return valueEnv;
	}
}
