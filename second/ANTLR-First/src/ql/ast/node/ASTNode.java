package ql.ast.node;

import ql.ast.visitor.ASTVisitor;

public interface ASTNode {

	public abstract void accept(ASTVisitor visitor);
}
