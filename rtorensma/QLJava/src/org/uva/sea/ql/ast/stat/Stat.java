package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.checker.FormVisitor;

public abstract class Stat implements ASTNode {
	
	public abstract <T> T accept(FormVisitor<T> visitor);
	
}
