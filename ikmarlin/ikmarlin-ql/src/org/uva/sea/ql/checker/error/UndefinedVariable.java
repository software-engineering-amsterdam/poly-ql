package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.ast.expr.Ident;

public abstract class UndefinedVariable extends UndefinedReferenceError {

	public static String getMessage(Ident variable) {
		return "the variable << " + variable.getName() + " >> is undefined";
	}

}
