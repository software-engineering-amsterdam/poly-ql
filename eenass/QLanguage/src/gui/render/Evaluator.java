package gui.render;

import java.util.Map;

import ast.expr.Identifier;
import ast.expr.binExpr.Add;
import ast.expr.binExpr.And;
import ast.expr.binExpr.Div;
import ast.expr.binExpr.Eq;
import ast.expr.binExpr.GEq;
import ast.expr.binExpr.GT;
import ast.expr.binExpr.LEq;
import ast.expr.binExpr.LT;
import ast.expr.binExpr.Mul;
import ast.expr.binExpr.NEq;
import ast.expr.binExpr.Or;
import ast.expr.binExpr.Sub;
import ast.expr.literal.BoolLiteral;
import ast.expr.literal.IntLiteral;
import ast.expr.literal.StrLiteral;
import ast.expr.unExpr.Neg;
import ast.expr.unExpr.Not;
import ast.expr.unExpr.Pos;
import ast.value.Bool;
import ast.value.Int;
import ast.value.Str;
import ast.value.Value;
import ast.visitors.ExprVisitor;


public class Evaluator implements ExprVisitor<Value> {
	
	private Map<Identifier, Value> environment;
 
	public Evaluator(Map<Identifier, Value> environment) {
		this.environment = environment ;
	}

	@Override
	public Value visit(Pos node) {
		return node.getOperand().accept(this).pos();
	}

	@Override
	public Value visit(Neg node) {
		return node.getOperand().accept(this).neg();
	}

	@Override
	public Value visit(Not node) {
		return node.getOperand().accept(this).not();
	}

	@Override
	public Value visit(Add node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.add(r);
	}

	@Override
	public Value visit(And node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.and(r);
	}

	@Override
	public Value visit(Div node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.div(r);
	}

	@Override
	public Value visit(Eq node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.eq(r);
	}

	@Override
	public Value visit(GEq node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.geq(r);
	}

	@Override
	public Value visit(GT node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.gt(r);
	}

	@Override
	public Value visit(LEq node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.leq(r);
	}

	@Override
	public Value visit(LT node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.lt(r);
	}

	@Override
	public Value visit(Mul node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.mul(r);
	}

	@Override
	public Value visit(NEq node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.neq(r);
	}

	@Override
	public Value visit(Or node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.or(r);
	}

	@Override
	public Value visit(Sub node) {
		Value l = node.getLhs().accept(this);
		Value r = node.getRhs().accept(this);
		return l.sub(r);
	}

	@Override
	public Value visit(BoolLiteral node) {
		return new Bool(node.getVal());
	}

	@Override
	public Value visit(Identifier node) {
		assert environment.containsKey(node);
		return environment.get(node);
	}

	@Override
	public Value visit(IntLiteral node) {
		return new Int(node.getVal());
	}

	@Override
	public Value visit(StrLiteral node) {
		return new Str(node.getVal());
	}

	
}