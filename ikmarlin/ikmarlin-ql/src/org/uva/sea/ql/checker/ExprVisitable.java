package org.uva.sea.ql.checker;

public interface ExprVisitable {
	
	public abstract <T> T accept(ExprVisitor<T> qlv);
	
}
