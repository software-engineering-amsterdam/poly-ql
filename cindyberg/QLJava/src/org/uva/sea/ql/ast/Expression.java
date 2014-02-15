package org.uva.sea.ql.ast;


public abstract class Expression extends ASTNode {

	public abstract void accept(IVisitor visitor);
	public abstract String show();
}
