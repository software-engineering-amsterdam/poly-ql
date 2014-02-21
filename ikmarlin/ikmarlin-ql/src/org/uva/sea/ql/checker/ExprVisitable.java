package org.uva.sea.ql.checker;

public interface ExprVisitable {
	
	public abstract void accept(ExprVisitor qlv);
	
}
