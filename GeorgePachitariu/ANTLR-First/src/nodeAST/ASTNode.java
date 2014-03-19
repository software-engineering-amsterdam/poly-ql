package nodeAST;

import visitor.ASTVisitor;

public interface ASTNode {

	public abstract void accept(ASTVisitor visitor);
}
