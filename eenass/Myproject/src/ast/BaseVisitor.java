package ast;

import ast.expr.IdentLiteral;
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
import ast.expr.types.BoolType;
import ast.expr.types.IntType;
import ast.expr.types.StrType;
import ast.expr.unExpression.Neg;
import ast.expr.unExpression.Not;
import ast.expr.unExpression.Pos;

public class BaseVisitor implements Visitor<Boolean> {

	public BaseVisitor(){
	}

	@Override
	public Boolean visit(Pos node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(Neg node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(Not node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(Add node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(And node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(Div node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(Eq node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(GEq node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(GT node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(LEq node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(LT node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(Mul node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(NEq node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(Or node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(Sub node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(IdentLiteral node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(IntLiteral node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(StrLiteral node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(BoolType node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(IntType node) {
		System.out.print(node.show());
		return true;
	}

	@Override
	public Boolean visit(StrType node) {
		System.out.print(node.show());
		return true;
	}

}
