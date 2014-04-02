package ast.expr.binExpr;

import typecheck.SymbolTable;
import ast.expr.Expr;
import ast.types.BoolType;
import ast.types.Type;
import ast.visitors.ExprVisitor;

public class GEq extends BinExpr{

	public GEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymbolTable symbolTable) {
		return new BoolType();
	}

}
