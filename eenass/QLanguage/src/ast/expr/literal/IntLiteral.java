package ast.expr.literal;

import typecheck.SymbolTable;
import ast.types.IntType;
import ast.types.Type;
import ast.visitors.ExprVisitor;

public class IntLiteral extends Literals{
	
	private final int val;

	public IntLiteral(int val) {
		this.val = val;
	}

	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymbolTable symbolTable) {
		return new IntType();
	}

	public int getVal() {
		return this.val;
	}
}
