package expr.signExpr;

import typeChecker.ASTVisitor;
import types.BoolType;
import types.Type;
import expr.Expression;
import expr.UnaryExpr;

public class Pos extends UnaryExpr {

	public Pos(Expression expr) {
		super(expr);
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this); 
		this.first.accept(visitor);
	}
	
	@Override
	public boolean isBoolean() {
		return false;
	}
	
	@Override
	public String toString() {
		return "+" + this.first.toString(); 
	}
	
	@Override
	public boolean isNumeric() {
		return true;
	}

	@Override
	public boolean isComparable() {
		return true;
	}

	@Override
	public boolean isTheSameType(Expression exp) {
		return this.first.isTheSameType(exp);
	}
	
	@Override
	public boolean hasValidOperatorsType() {
		if(this.first.isNumeric()) 	
			return true;
		return false;
	}
	
	@Override
	public Type getType() {
		return this.first.getType();
	}
}
