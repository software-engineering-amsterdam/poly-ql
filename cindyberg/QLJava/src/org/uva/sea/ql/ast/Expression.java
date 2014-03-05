package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.typechecker.TypeEnvironment;


public abstract class Expression extends ASTNode {

	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	public abstract String toString();
	public abstract Type typeOf(TypeEnvironment environment);

}
