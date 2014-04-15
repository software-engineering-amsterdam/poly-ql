package ast.literals;


import java.util.Map;

import ast.Visitor;
import ast.type.Booltype;
import ast.type.Inttype;
import ast.type.Type;
import expr.Ident;

public class IntLiteral extends Literal{

	private final Integer value; 
	public IntLiteral(Integer value) {
		this.value= value;
	}


	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(Map<Ident,Type> symboles) {
		// TODO Auto-generated method stub
		return new Inttype();
		//return null;
	}


	public Integer getValue() {
		return value;
	}

}
