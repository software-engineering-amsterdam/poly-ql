package ast.expr.unExpression;

import typecheck.SymbolTable;
import ast.Visitor;
import ast.expr.Expr;
import ast.types.BoolType;
import ast.types.Type;

public class Not extends UnExpr{
	public Not(Expr operand){
		super(operand);		
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymbolTable symboles) {
		return new BoolType();
	}
}
