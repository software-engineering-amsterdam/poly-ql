package ast.expr.literal;

import typecheck.Symboles;
import ast.Visitor;
import ast.types.IntType;
import ast.types.Types;

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
	public Types typeof(Symboles symb) {
		return new IntType();
	}

	public int getVal() {
		return val;
	}

}
