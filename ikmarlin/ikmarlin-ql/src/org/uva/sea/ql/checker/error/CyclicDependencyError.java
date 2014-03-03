package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.checker.helper.Dependency;

public abstract class CyclicDependencyError extends DependencyError {

	public static String getMessage(Dependency d) {
		return "the conditional variable << "+d.getX()+" >> and the question << "+d.getY()+" >> depend on one another.";
	}

}
