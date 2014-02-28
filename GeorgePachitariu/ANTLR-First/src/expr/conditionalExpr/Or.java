package expr.conditionalExpr;

import typeChecker.ASTVisitor;
import types.BoolType;
import types.Type;
import expr.BinaryExpr;
import expr.Expression;

public class Or extends BinaryExpr {

	public Or(Expression first, Expression second) {
		super(first,second);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
		this.first.accept(visitor);
		this.second.accept(visitor);
	}
	
	@Override
	public boolean isBoolean() {
		return true;
	}
	
	@Override
	public String toString() {
		return this.first.toString() + "||" + this.second.toString(); 
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
		if(this.first.isTheSameType(this.second) &&
			this.first.isBoolean() ) 	
			return true;
		return false;
	}
	
	@Override
	public Type getType() {
		return new BoolType();
	}
}
