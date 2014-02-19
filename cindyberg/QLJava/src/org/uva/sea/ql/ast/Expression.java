package org.uva.sea.ql.ast;


public abstract class Expression extends ASTNode {

	public abstract <T> void accept(ExpressionVisitor<T> visitor);
	public abstract String show();
}
