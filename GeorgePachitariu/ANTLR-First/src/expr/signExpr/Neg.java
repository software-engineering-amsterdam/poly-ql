package expr.signExpr;

import typeChecker.ASTVisitor;
import expr.Expr;
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
	public boolean isBoolean() {
		return false;
	}
	
	@Override
	public String toString() {
		return "-" + this.first.toString(); 
	}
}
