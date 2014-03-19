package org.uva.sea.ql.gui;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.ast.types.Undefined;

public interface TypeVisitor<T,U> {
	T visit(Bool type, U arg);
	T visit(Int type, U arg);
	T visit(Str type, U arg);
	T visit(Undefined type, U arg);
}
