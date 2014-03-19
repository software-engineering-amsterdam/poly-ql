package ast.expr;

import typecheck.SymbolTable;
import ast.Visitor;
import ast.expr.types.Type;

public class Identifier extends Expr{
	
	private final String identName;

	public Identifier(String identName) {
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
	public Type typeof(SymbolTable symb) {
		if (symb.containsSymb(this.getIdentName())){
			return symb.getType(this.getIdentName());
		}
		return null;
	}
	
	public int hashCode(){
		return identName.hashCode();
	}
	
	public boolean equals(Object other){
		return identName.equals(((Identifier)other).getIdentName());
	}

}
