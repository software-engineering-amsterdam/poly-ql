package expr.signExpr;

import typeChecker.ASTVisitor;
import types.BoolType;
import types.Type;
import expr.Expression;
import expr.UnaryExpr;

public class Not extends UnaryExpr {

	public Not(Expression expr) {
		super(expr);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this); 
		this.first.accept(visitor);
	}
	
	@Override
	public boolean isBoolean() {
		return true;
	}
	
	@Override
	public String toString() {
		return "!" + this.first.toString(); 
	}
	
	@Override
	public boolean isNumeric() {
		return false;
	}

	@Override
	public boolean isComparable() {
		return false;
	}

	@Override
	public boolean isTheSameType(Expression exp) {
		return exp.isBoolean();
	}
	
	@Override
	public boolean hasValidOperatorsType() {
		if(this.first.isBoolean()) 	
			return true;
		return false;
	}
	
	@Override
	public Type getType() {
		return this.first.getType();
	}
}
