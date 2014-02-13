package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.operators.IOperatorVisitor;


public abstract class Expression implements ASTNode {

	public abstract void accept(IOperatorVisitor visitor);
}
