package parser;

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
import ast.visitors.ExprVisitor;

public class ExprParser implements ExprVisitor<String>{

	public ExprParser() {
	}

	@Override
	public String visit(Pos node) {
		return "+ " + node.getOperand().accept(this);
	}

	@Override
	public String visit(Neg node) {
		return "- " + node.getOperand().accept(this);
	}

	@Override
	public String visit(Not node) {
		return "! " + node.getOperand().accept(this);
	}

	@Override
	public String visit(Add node) {
		return "(" + node.getLhs().accept(this) + " + " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(And node) {
		return "(" + node.getLhs().accept(this) + " && " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Div node) {
		return "(" + node.getLhs().accept(this) + " / " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Eq node) {
		return "(" + node.getLhs().accept(this) + " == " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(GEq node) {
		return "(" + node.getLhs().accept(this) + " >= " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(GT node) {
		return "(" + node.getLhs().accept(this) + " > " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(LEq node) {
		return "(" + node.getLhs().accept(this) + " <= " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(LT node) {
		return "(" + node.getLhs().accept(this) + " < " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Mul node) {
		return "(" + node.getLhs().accept(this) + " * " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(NEq node) {
		return "(" + node.getLhs().accept(this) + " != " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Or node) {
		return "(" + node.getLhs().accept(this) + " || " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(Sub node) {
		return "(" + node.getLhs().accept(this) + " - " + node.getRhs().accept(this) + ")";
	}

	@Override
	public String visit(BoolLiteral node) {
		return Boolean.toString(node.getVal());
	}

	@Override
	public String visit(Identifier node) {
		return node.getIdentName();
	}

	@Override
	public String visit(IntLiteral node) {
		return Integer.toString(node.getVal());
	}

	@Override
	public String visit(StrLiteral node) {
		return node.getVal();
	}

}
