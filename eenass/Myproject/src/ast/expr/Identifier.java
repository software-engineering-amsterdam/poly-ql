package ast.expr;

import typecheck.Symboles;
import ast.Visitor;
import ast.expr.types.Types;

public class IdentLiteral extends Expr{
	
	private final String identName;

	public IdentLiteral(String identName) {
		this.identName = identName;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	
	public String getIdentName() {
		return identName;
	}

	@Override
	public Types typeof(Symboles symb) {
		if (symb.containsSymb(this.getIdentName())){
			return symb.getType(this.getIdentName());
		}
		return null;
	}

	@Override
	public String show() {
		return identName;
	}

}
