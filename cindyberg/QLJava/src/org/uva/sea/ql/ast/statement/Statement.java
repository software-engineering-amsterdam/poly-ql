package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.StatementVisitor;

public abstract class Statement extends ASTNode{
	
	public abstract void accept(StatementVisitor visitor);
}
