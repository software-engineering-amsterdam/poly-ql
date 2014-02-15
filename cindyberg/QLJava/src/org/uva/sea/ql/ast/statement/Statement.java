package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.IVisitor;

public abstract class Statement extends ASTNode{
	
	public abstract void accept(IVisitor visitor);

}
