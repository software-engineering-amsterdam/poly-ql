package ast.expr.literal;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.types.BoolType;
import ast.expr.types.Type;

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
	public Type typeof(Symboles symb) {
		return new BoolType();
	}
}
