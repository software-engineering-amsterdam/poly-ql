package ast.expr.binExpr;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.Expr;
import ast.expr.types.IntType;
import ast.expr.types.Type;

public class Add extends BinExpr{

	public Add(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
	
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(Symboles symb) {
		return new IntType();
		
	}
	
}
