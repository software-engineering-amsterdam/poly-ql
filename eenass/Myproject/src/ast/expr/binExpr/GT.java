package ast.expr.binExpr;

import typecheck.SymbolTable;
import ast.Visitor;
import ast.expr.Expr;
import ast.types.BoolType;
import ast.types.Type;

public class GT extends BinExpr{

	public GT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymbolTable symb) {
		return new BoolType();
	}

}
