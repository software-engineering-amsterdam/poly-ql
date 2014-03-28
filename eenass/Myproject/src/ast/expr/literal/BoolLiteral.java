package ast.expr.literal;

import typecheck.SymbolTable;
import ast.Visitor;
import ast.types.BoolType;
import ast.types.Type;

public class BoolLiteral extends Literals{
	private final boolean val;
	
	public BoolLiteral(boolean val) {
		this.val = val;
	}

	public boolean getVal() {
		return this.val;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymbolTable symb) {
		return new BoolType();
	}
}
