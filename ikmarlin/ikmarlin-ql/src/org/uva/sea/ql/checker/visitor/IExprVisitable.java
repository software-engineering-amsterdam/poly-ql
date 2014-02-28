package org.uva.sea.ql.checker.visitor;

import org.uva.sea.ql.checker.visitor.IExprVisitor;

public interface IExprVisitable {
	
	public abstract <T> T accept(IExprVisitor<T> ev);
	
}
