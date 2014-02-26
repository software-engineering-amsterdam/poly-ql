package ast.expr.unExpression;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.Expr;
import ast.expr.types.IntType;
import ast.expr.types.Types;

public class Pos extends UnExpr{
	public Pos(Expr operand){
		super(operand);		
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Types typeof(Symboles symb) {
		return new IntType();
	}

	@Override
	public String show() {
		return "+ " + show_operand();
	}
}
