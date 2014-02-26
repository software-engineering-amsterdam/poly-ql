package ast.expr.literal;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.types.StrType;
import ast.expr.types.Types;

public class StrLiteral extends Literals{
	
	private final String val;

	public StrLiteral(String val) {
		this.val = val;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Types typeof(Symboles symb) {
		return new StrType();
	}

	public String getVal() {
		return this.val;
	}

	@Override
	public String show() {
		return val.toString();
	}

}
