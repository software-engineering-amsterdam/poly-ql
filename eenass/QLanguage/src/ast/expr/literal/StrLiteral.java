package ast.expr.literal;

import typecheck.SymbolTable;
import ast.types.StrType;
import ast.types.Type;
import ast.visitors.ExprVisitor;

public class StrLiteral extends Literals{
	
	private final String val;

	public StrLiteral(String val) {
		this.val = val;
	}

	@Override
	public <T> T accept(ExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type typeof(SymbolTable symbolTable) {
		return new StrType();
	}

	public String getVal() {
		return this.val;
	}
	
	public int hashCode(){
		return val.hashCode();
	}
	
	public boolean equals(Object other){
		return val.equals(((StrLiteral)other).getVal());
	}
}
