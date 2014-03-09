package expr;

import typeChecker.ASTVisitor;

public interface ASTNode {

	public abstract void accept(ASTVisitor visitor);
}
