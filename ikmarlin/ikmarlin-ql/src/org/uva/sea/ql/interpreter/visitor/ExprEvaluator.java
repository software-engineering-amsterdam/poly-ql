package org.uva.sea.ql.interpreter.visitor;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.IntLiteral;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StrLiteral;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.checker.visitor.IExprVisitor;
import org.uva.sea.ql.interpreter.value.Bool;
import org.uva.sea.ql.interpreter.value.Int;
import org.uva.sea.ql.interpreter.value.Str;
import org.uva.sea.ql.interpreter.value.Undefined;
import org.uva.sea.ql.interpreter.value.Value;

public class ExprEvaluator implements IExprVisitor<Value<?>> {
	
	private Map<String, Value<?>> valueTable;
	
	public ExprEvaluator(Map<String, Value<?>> valueTable){
		this.valueTable = valueTable;
	}

	@Override
	public Value<?> visit(Add ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.add(right);
	}

	@Override
	public Value<?> visit(Sub ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.sub(right);
	}

	@Override
	public Value<?> visit(Mul ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.mul(right);
	}

	@Override
	public Value<?> visit(Div ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.div(right);
	}

	@Override
	public Value<?> visit(Pos ex) {
		Value<?> arg = ex.getArg().accept(this);
		return arg.pos();
	}

	@Override
	public Value<?> visit(Neg ex) {
		Value<?> arg = ex.getArg().accept(this);
		return arg.neg();
	}

	@Override
	public Value<?> visit(And ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.and(right);
	}

	@Override
	public Value<?> visit(Or ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.or(right);
	}

	@Override
	public Value<?> visit(Not ex) {
		Value<?> arg = ex.getArg().accept(this);
		return arg.not();
	}

	@Override
	public Value<?> visit(LEq ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.leq(right);
	}

	@Override
	public Value<?> visit(LT ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.lt(right);
	}

	@Override
	public Value<?> visit(GT ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.gt(right);
	}

	@Override
	public Value<?> visit(GEq ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.geq(right);
	}

	@Override
	public Value<?> visit(Eq ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.eq(right);
	}

	@Override
	public Value<?> visit(NEq ex) {
		Value<?> left = ex.getLhs().accept(this);
		Value<?> right = ex.getRhs().accept(this);
		return left.neq(right);
	}

	@Override
	public Value<?> visit(Ident ex) {
		Value<?> value = new Undefined();
		if(valueTable.containsKey(ex.getName())){
			value = valueTable.get(ex.getName());
		}
		return value;
	}

	@Override
	public Value<?> visit(BoolLiteral ex) {
		return new Bool(ex.getValue());
	}

	@Override
	public Value<?> visit(StrLiteral ex) {
		return new Str(ex.getValue());
	}

	@Override
	public Value<?> visit(IntLiteral ex) {
		return new Int(ex.getValue());
	}

}