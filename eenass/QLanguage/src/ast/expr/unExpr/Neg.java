package ast.expr.unExpr;

import typecheck.SymbolTable;
import ast.expr.Expr;
import ast.types.IntType;
import ast.types.Type;
import ast.visitors.ExprVisitor;

public class Neg extends UnExpr{
	
	public Neg(Expr operand){
		super(operand);		
	}

	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymbolTable symbolTable) {
		return new IntType();
	}
}
