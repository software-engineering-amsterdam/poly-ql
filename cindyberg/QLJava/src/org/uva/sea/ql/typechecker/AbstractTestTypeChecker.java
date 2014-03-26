package org.uva.sea.ql.typechecker;

import problems.Problems;

public abstract class AbstractTestTypeChecker {
	
	protected final TypeEnvironment env;
	protected final StatementChecker statementChecker;
	protected final Problems problems;
	
	public AbstractTestTypeChecker(){
		env = new TypeEnvironment();
		problems = new Problems();
		statementChecker = new StatementChecker(env, problems);
	}

}
