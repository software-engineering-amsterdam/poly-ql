package org.uva.sea.ql.checker;

public interface StmtVisitable {
	
	public abstract void accept(StmtVisitor sv);
	
}
