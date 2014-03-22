package org.uva.sea.ql.checker.exception.error;

import org.uva.sea.ql.checker.helper.Dependency;

public class CyclicDependencyError extends DependencyError {
	
	private static final long serialVersionUID = 1L;
	
	private Dependency pair;
	
	public CyclicDependencyError(Dependency pair){
		this.pair = pair;
	}

	@Override
	public String getMessage() {
		return "<< "+pair.getX()+" >> and << "+pair.getY()+" >> depend on one another.";
	}

}
