package expr.signExpr;

import typeChecker.ASTVisitor;
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
}
