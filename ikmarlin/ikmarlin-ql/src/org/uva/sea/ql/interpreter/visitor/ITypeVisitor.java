package org.uva.sea.ql.interpreter.visitor;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Null;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Undefined;

public interface ITypeVisitor<T> {
	
	public abstract T visit(Bool type);
	public abstract T visit(Str type);
	public abstract T visit(Int type);
	public abstract T visit(Undefined type);
	public abstract T visit(Null type);

}
