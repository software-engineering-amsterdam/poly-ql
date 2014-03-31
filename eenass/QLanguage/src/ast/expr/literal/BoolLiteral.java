package ast.expr.literal;

import typecheck.SymbolTable;
import ast.types.BoolType;
import ast.types.Type;
import ast.visitors.ExprVisitor;

public class BoolLiteral extends Literals{
	
	private final boolean val;
	
	public BoolLiteral(boolean val) {
		this.val = val;
	}

	public boolean getVal() {
		return this.val;
	}

	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymbolTable symbolTable) {
		return new BoolType();
	}
}
