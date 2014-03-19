package ast.expr.literal;

import typecheck.SymbolTable;
import ast.Visitor;
import ast.types.IntType;
import ast.types.Type;

public class IntLiteral extends Literals{
	
	private final int val;

	public IntLiteral(int val) {
		this.val = val;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymbolTable symb) {
		return new IntType();
	}

	public int getVal() {
		return this.val;
	}
}
