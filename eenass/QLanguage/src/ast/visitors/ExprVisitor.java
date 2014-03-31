package ast.visitors;

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

public interface ExprVisitor<T>{
	T visit(Pos node);
	T visit(Neg node);
	T visit(Not node);
	T visit(Add node);
	T visit(And node);
	T visit(Div node);
	T visit(Eq node);
	T visit(GEq node);
	T visit(GT node);
	T visit(LEq node);
	T visit(LT node);
	T visit(Mul node);
	T visit(NEq node);
	T visit(Or node);
	T visit(Sub node);
	T visit(BoolLiteral node);
	T visit(Identifier node);
	T visit(IntLiteral node);
	T visit(StrLiteral node);
}
