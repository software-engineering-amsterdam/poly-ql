package ast.literals;

import java.util.Map;

import ast.Visitor;
import ast.type.Booltype;
import ast.type.Strtype;
import ast.type.Type;
import expr.Ident;

public class StrLiteral extends Literal{

	private final String value; 
	public StrLiteral(String value) {
		this.value= value;
	}


	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(Map<Ident,Type> symboles) {
		// TODO Auto-generated method stub
		return new Strtype();
		//return null;
	}


	public String getValue() {
		return value;
	}


}
