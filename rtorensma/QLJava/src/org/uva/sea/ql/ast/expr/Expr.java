package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.checker.ExprVisitor;

public abstract class Expr implements ASTNode {

	public abstract <T> T accept(ExprVisitor<T> visitor);
}
