package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.ast.expr.Ident;

public abstract class UndefinedQuestion extends Error {

	public static String getMessage(Ident question) {
		return "the question << " + question.getName() + " >> is undefined";
	}

}
