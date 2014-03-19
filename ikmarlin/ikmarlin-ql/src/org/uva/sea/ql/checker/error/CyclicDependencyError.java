package org.uva.sea.ql.checker.error;

import org.uva.sea.ql.checker.helper.Dependency;

public class CyclicDependencyError extends DependencyError {
	
	private Dependency pair;
	
	public CyclicDependencyError(Dependency pair){
		this.pair = pair;
	}

	@Override
	public String getMessage() {
		return "<< "+pair.getX()+" >> and << "+pair.getY()+" >> depend on one another.";
	}

}
