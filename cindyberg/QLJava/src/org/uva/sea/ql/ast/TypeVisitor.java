package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MissingType;
import org.uva.sea.ql.ast.type.StringType;

public interface TypeVisitor<T> {

	T visit (IntegerType type);
	T visit (StringType type);
	T visit (BooleanType booleanType);
	T visit(MissingType missingType);

}
