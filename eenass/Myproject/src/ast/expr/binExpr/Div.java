package ast.expr.binExpr;

import typecheck.SymboleTable;
import ast.Visitor;
import ast.expr.Expr;
import ast.expr.types.IntType;
import ast.expr.types.Type;

public class Div extends BinExpr{

	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymboleTable symb) {
		return new IntType();
	}
}		
