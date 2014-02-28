package org.uva.sea.ql.checker.error;

public abstract class DuplicateQuestion extends Error {

	public static String getMessage(String ident) {
		return "the question << "+ident+" >> has been defined with multiple types";
	}

}
