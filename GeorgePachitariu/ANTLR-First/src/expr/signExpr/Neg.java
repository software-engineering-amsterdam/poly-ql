package expr.signExpr;

import typeChecker.ASTVisitor;
import types.Type;
import expr.Expression;
import expr.UnaryExpr;

public class Neg extends UnaryExpr {

	public Neg(Expression expr) {
		super(expr);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this); 
		this.first.accept(visitor);
	}
	
	@Override
	public String toString() {
		return "-" + this.first.toString(); 
	}
	
	@Override
	public Type getType() {
		return this.first.getType();
	}
	
	@Override
	public boolean areOperandsTypeValid() {
		Type t1=this.first.getType();
		return t1.isArithmetic();
	}
}
