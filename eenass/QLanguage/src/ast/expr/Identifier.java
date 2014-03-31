package ast.expr;

import typecheck.SymbolTable;
import ast.types.Type;
import ast.visitors.ExprVisitor;

public class Identifier extends Expr{
	
	private final String identName;

	public Identifier(String identName) {
		this.identName = identName;
	}

	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	
	public String getIdentName() {
		return identName;
	}

	@Override
	public Type typeof(SymbolTable symb) {
		assert(symb.containsSymbol(this));
		return symb.getType(this);
	}
	
	public int hashCode(){
		return identName.hashCode();
	}
	
	public boolean equals(Object other){
		return identName.equals(((Identifier)other).getIdentName());
	}

}
