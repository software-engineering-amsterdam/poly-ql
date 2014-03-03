package org.uva.sea.ql.checker.warning;

public abstract class DuplicateLabel extends DuplicateWarning {
	
	public static String getMessage(String label) {
		return "WARNING: the question <<"+label+">> has been defined multiple times";
	}

}
