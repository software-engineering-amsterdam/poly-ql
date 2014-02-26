package ast.expr.binExpr;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.Expr;
import ast.expr.types.BoolType;
import ast.expr.types.Types;

public class GT extends BinExpr{

	public GT(Expr lhs, Expr rhs) {
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

	@Override
	public String show() {
		return "(" + show_lhs() + " > " + show_rhs() + ")";
	}

}
