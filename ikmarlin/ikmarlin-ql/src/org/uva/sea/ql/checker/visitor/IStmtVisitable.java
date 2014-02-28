package org.uva.sea.ql.checker.visitor;


public interface IStmtVisitable {
	
	public abstract void accept(IStmtVisitor sv);
	
}
