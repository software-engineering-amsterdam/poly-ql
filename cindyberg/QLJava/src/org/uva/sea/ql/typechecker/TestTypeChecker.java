package org.uva.sea.ql.typechecker;

import problems.Problems;

public abstract class TestTypeChecker {
	
	public TypeEnvironment env;
	public StatementChecker stat;
	public Problems problems;
	
	public TestTypeChecker(){
		env = new TypeEnvironment();
		problems = new Problems();
		stat = new StatementChecker(env, problems);
	}

}
