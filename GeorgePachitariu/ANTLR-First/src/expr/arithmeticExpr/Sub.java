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
	public String toString() {
		return this.first.toString() + "-" + this.second.toString(); 
	}
	
	@Override
	public Type getType() {
		return this.first.getType();
	}
	
	@Override
	public boolean areOperandsTypeValid() {
		Type t1=this.first.getType();
		Type t2=this.second.getType();
		return (t1.isCompatibleWith(t2) &&
				      t1.isArithmetic());
	}
}
