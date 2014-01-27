package org.uva.sea.ql.ast.types;

public interface Visitor<T, U> {
	T visit(Bool type, U arg);
	T visit(Int type, U arg);
	T visit(Money type, U arg);
	T visit(Str type, U arg);
	T visit(Numeric type, U arg);
	T visit(org.uva.sea.ql.check.Error type, U arg);
}
