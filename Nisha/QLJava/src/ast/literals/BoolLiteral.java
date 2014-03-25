package ast.literals;
import java.util.Map;

import ast.Visitor;
import ast.type.Type;
import expr.Ident;

public class BoolLiteral extends Literal{

	private final boolean value;
	
	public BoolLiteral(Boolean value) {
		this.value= value;
	}


	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(Map<Ident,Type> symboles) {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean getValue() {
		return value;
	}

}
