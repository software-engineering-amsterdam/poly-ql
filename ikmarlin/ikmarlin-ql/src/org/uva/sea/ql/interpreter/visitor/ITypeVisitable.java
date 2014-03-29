package org.uva.sea.ql.interpreter.visitor;

public interface ITypeVisitable {
	
	public abstract <T> T accept(ITypeVisitor<T> tv);

}
