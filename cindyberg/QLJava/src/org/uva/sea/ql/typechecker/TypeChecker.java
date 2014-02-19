package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.statement.Form;

public class TypeChecker {
	
	List<Error> errorlist = new ArrayList<Error>();
	Environment environment = new Environment();

	public TypeChecker(Form form){
		StatementChecker statementchecker = new StatementChecker(environment, errorlist );
		statementchecker.visit(form);
	}
}
