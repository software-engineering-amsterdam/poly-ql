package expr.relationalExpr;

import typeChecker.ASTVisitor;
import expr.BinaryExpr;
import expr.Expression;

public class LEq extends BinaryExpr {

	public LEq(Expression first, Expression second) {
		super(first,second);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this); 
		this.first.accept(visitor);
		this.second.accept(visitor);
	}
}
