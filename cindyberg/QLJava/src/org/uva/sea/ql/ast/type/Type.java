package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.IVisitor;


public abstract class Type extends ASTNode {
	
	public abstract void accept(IVisitor visitor);
	public abstract String show();

}
