package ast.expr.unExpression;

import typecheck.SymbolTable;
import ast.Visitor;
import ast.expr.Expr;
import ast.types.IntType;
import ast.types.Type;

public class Pos extends UnExpr{
	public Pos(Expr operand){
		super(operand);		
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymbolTable symb) {
		return new IntType();
	}

}
