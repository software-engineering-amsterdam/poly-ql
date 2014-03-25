package gui;

import java.util.Map;

import ast.Visitor;
import ast.evaluate.Bool;
import ast.evaluate.Int;
import ast.evaluate.Str;
import ast.evaluate.Value;
import ast.form.Block;
import ast.form.Computedquest;
import ast.form.Form;
import ast.form.IfElse;
import ast.form.Ifstate;
import ast.form.Question;
import ast.form.StatementList;
import ast.literals.BoolLiteral;
import ast.literals.IntLiteral;
import ast.literals.StrLiteral;
import ast.type.Booltype;
import ast.type.Inttype;
import ast.type.Strtype;
import expr.Ident;
import expr.conditional.And;
import expr.conditional.Or;
import expr.operation.Add;
import expr.operation.Div;
import expr.operation.Mul;
import expr.operation.Sub;
import expr.relational.Eq;
import expr.relational.GEq;
import expr.relational.GT;
import expr.relational.LEq;
import expr.relational.LT;
import expr.relational.NEq;
import expr.unary.Neg;
import expr.unary.Not;
import expr.unary.Pos;

public class Evaluation implements Visitor<Value> {
	
	private final Map<Ident, Value> env;
	
	public Evaluation(Map<Ident, Value> env)
	{
		this.env = env;
	}

	@Override
	public Value visit(And node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.and(rhs);
	}

	@Override
	public Value visit(Or node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.or(rhs);
	}

	@Override
	public Value visit(Ident node) {
		if (env.containsKey(node)){
			return env.get(node);
		}
		return null;
	}

	@Override
	public Value visit(Add node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.add(rhs);
	}

	@Override
	public Value visit(Div node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.div(rhs);
	}

	@Override
	public Value visit(Mul node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.mul(rhs);
	}

	@Override
	public Value visit(Sub node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.sub(rhs);
	}

	@Override
	public Value visit(Eq node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.eq(rhs);
	}

	@Override
	public Value visit(GEq node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.geq(rhs);
	}

	@Override
	public Value visit(GT node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.gt(rhs);
	}

	@Override
	public Value visit(LEq node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.leq(rhs);
	}

	@Override
	public Value visit(LT node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.lt(rhs);
	}

	@Override
	public Value visit(NEq node) {
		Value lhs = node.getLhs().accept(this);
		Value rhs = node.getRhs().accept(this);
		return lhs.neq(rhs);
	}

	@Override
	public Value visit(Neg node) {
		Value operand = node.getOperand().accept(this);
		return operand.neg();
	}

	@Override
	public Value visit(Not node) {
		Value operand = node.getOperand().accept(this);
		return operand.not();
	
	}

	@Override
	public Value visit(BoolLiteral node) {
		return new Bool(node.getValue());
	}

	@Override
	public Value visit(IntLiteral node) {
		return new Int(node.getValue());
	}

	@Override
	public Value visit(StrLiteral node) {
		return new Str(node.getValue());
	}

	@Override
	public Value visit(Form node) {
		return null;
	}

	@Override
	public Value visit(Question node) {
		return null;
	}

	@Override
	public Value visit(IfElse node) {
		return null;
	}

	@Override
	public Value visit(Ifstate node) {
		return null;
	}

	@Override
	public Value visit(Booltype node) {
		return null;
	}

	@Override
	public Value visit(Inttype node) {
		return null;
	}

	@Override
	public Value visit(Strtype node) {
		return null;
	}

	@Override
	public Value visit(Pos node) {
		return null;
	}

	@Override
	public Value visit(StatementList statementList) {
		return null;
	}

	@Override
	public Value visit(Computedquest node) {
		return null;
	}

	@Override
	public Value visit(Block block) {
		return null;
	}

	
}
