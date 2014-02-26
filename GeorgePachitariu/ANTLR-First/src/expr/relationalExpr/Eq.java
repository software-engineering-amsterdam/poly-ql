package expr.relationalExpr;

import typeChecker.ASTVisitor;
import expr.BinaryExpr;
import expr.Expression;

public class Eq extends BinaryExpr {

	public Eq(Expression first, Expression second) {
		super(first,second);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this); 
		this.first.accept(visitor);
		this.second.accept(visitor);
	}
}
