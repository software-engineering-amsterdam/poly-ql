package ast.expr.binExpr;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.Expr;
import ast.expr.types.BoolType;
import ast.expr.types.Types;

public class Eq extends BinExpr{

	public Eq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Types typeof(Symboles symb) {
		return new BoolType();
	}

}
