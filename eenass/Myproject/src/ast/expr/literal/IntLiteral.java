package ast.expr.literal;

import typecheck.SymboleTable;
import ast.Visitor;
import ast.expr.types.IntType;
import ast.expr.types.Type;

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
	public Type typeof(SymboleTable symb) {
		return new IntType();
	}

	public int getVal() {
		return this.val;
	}
}
