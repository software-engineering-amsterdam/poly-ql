package expr.arithmeticExpr;

import typeChecker.ASTVisitor;
import expr.BinaryExpr;
import expr.Expression;

public class Add extends BinaryExpr {	
	
	public Add(Expression first, Expression second) {
		super(first,second);
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
		this.first.accept(visitor);
		this.second.accept(visitor);
	}
}
