package ast.expr.unExpression;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.Expr;
import ast.expr.types.BoolType;
import ast.expr.types.Types;

public class Not extends UnExpr{
	public Not(Expr operand){
		super(operand);		
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Types typeof(Symboles symboles) {
		return new BoolType();
	}
}
