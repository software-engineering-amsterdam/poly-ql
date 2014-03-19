package gui;

import java.util.Collections;
import java.util.Map;

import ast.Visitor;
import ast.expr.Expr;
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
import ast.expr.evaluate.Bool;
import ast.expr.evaluate.Int;
import ast.expr.evaluate.Str;
import ast.expr.evaluate.Value;
import ast.expr.literal.BoolLiteral;
import ast.expr.literal.IntLiteral;
import ast.expr.literal.StrLiteral;
import ast.expr.types.BoolType;
import ast.expr.types.IntType;
import ast.expr.types.StrType;
import ast.expr.unExpression.Neg;
import ast.expr.unExpression.Not;
import ast.expr.unExpression.Pos;
import ast.statement.Block;
import ast.statement.ComputedQuestion;
import ast.statement.Form;
import ast.statement.IfStatement;
import ast.statement.IfelseStatement;
import ast.statement.Question;
import ast.statement.StatementList;


public class Evaluator implements Visitor<Value> {
	
	private final Map<Identifier, Value> environment;
 
	public Evaluator(Map<Identifier, Value> environment) {
		this.environment = environment ;
	}
	
	public static Value Evaluate(Expr expr, Map<Identifier, Value> env){
		Evaluator evaluator = new Evaluator(env);
		return expr.accept(evaluator);
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
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.add(r);
	}

	@Override
	public Value visit(And node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.and(r);
	}

	@Override
	public Value visit(Div node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.div(r);
	}

	@Override
	public Value visit(Eq node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		System.out.println("l " + l + " r " + r);
		return l.eq(r);
	}

	@Override
	public Value visit(GEq node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.geq(r);
	}

	@Override
	public Value visit(GT node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.gt(r);
	}

	@Override
	public Value visit(LEq node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.leq(r);
	}

	@Override
	public Value visit(LT node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.lt(r);
	}

	@Override
	public Value visit(Mul node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.mul(r);
	}

	@Override
	public Value visit(NEq node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.neq(r);
	}

	@Override
	public Value visit(Or node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.or(r);
	}

	@Override
	public Value visit(Sub node) {
		Value l = node.get_lhs().accept(this);
		Value r = node.get_rhs().accept(this);
		return l.sub(r);
	}

	@Override
	public Value visit(BoolLiteral node) {
		return new Bool(node.getVal());
	}

	@Override
	public Value visit(Identifier node) {
		System.out.println("Identifier visit " + environment.size());
		if (environment.containsKey(node)){
			System.out.println("true " + node.getIdentName() + " value " + environment.get(node));
			return environment.get(node);
		}
		return null;
	}

	@Override
	public Value visit(IntLiteral node) {
		return new Int(node.getVal());
	}

	@Override
	public Value visit(StrLiteral node) {
		return new Str(node.getVal());
	}

	@Override
	public Value visit(BoolType node) {
		return null;
	}

	@Override
	public Value visit(IntType node) {
		return null;
	}

	@Override
	public Value visit(StrType node) {
		return null;
	}

	@Override
	public Value visit(StatementList node) {
		return null;
	}

	@Override
	public Value visit(Question node) {
		return null;
	}

	@Override
	public Value visit(ComputedQuestion node) {
		return null;
	}

	@Override
	public Value visit(Block node) {
		return null;
	}

	@Override
	public Value visit(IfStatement node) {
		return null;
	}

	@Override
	public Value visit(IfelseStatement node) {
		return null;
	}

	@Override
	public Value visit(Form node) {
		return null;
	}

}