package ast.statement;

import ast.ASTNode;
import ast.visitors.StatementVisitor;

public abstract class Statement extends ASTNode{
	public abstract <T> T accept(StatementVisitor<T> visitor);
}
