package expr;

import typeChecker.ASTVisitor;

public interface Expr {
	
	public abstract void accept(ASTVisitor visitor);
}
