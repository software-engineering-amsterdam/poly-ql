package expr.arithmeticExpr;

import typeChecker.ASTVisitor;
import types.Type;
import expr.BinaryExpr;
import expr.Expression;

public class Sub extends BinaryExpr {

	public Sub(Expression first, Expression second) {
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
		return false;
	}
	
	@Override
	public String toString() {
		return this.first.toString() + "-" + this.second.toString(); 
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
		// result of the sub is the type of one of its operands
		return this.first.isTheSameType(exp);
	}
	
	@Override
	public boolean hasValidOperatorsType() {
		if(this.first.isTheSameType(this.second) &&
			this.first.isNumeric() ) 	
			return true;
		return false;
	}
	
	@Override
	public Type getType() {
		return this.first.getType();
	}
}
