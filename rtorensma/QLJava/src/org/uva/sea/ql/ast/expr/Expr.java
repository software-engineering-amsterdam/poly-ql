package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.checker.ExprVisitor;
import org.uva.sea.ql.checker.TypeEnvironment;

public abstract class Expr implements ASTNode {

	public abstract <T> T accept(ExprVisitor<T> visitor);
	public abstract Type typeOf(TypeEnvironment typeEnv);
}
