package org.uva.sea.ql.gui.startIDE;

import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.jacc.ParseException;
import org.uva.sea.ql.parser.jacc.Parser;
import org.uva.sea.ql.typechecker.StatementChecker;
import org.uva.sea.ql.typechecker.TypeEnvironment;

import problems.Problems;

public class TypeChecker {
	
	private final Parser parser;
	private final Problems problems;
	
	public TypeChecker(){
		this.parser = new Parser();
		this.problems = new Problems();	
	}

	public Problems getProblems(Form form) throws ParseException{
		checkDSL(form);
		return problems;
	}
	
	public Form runTypeChecker(String INPUT) throws ParseException {
		return parseDSL(INPUT);
	}
	
	private void checkDSL(Form form) throws ParseException{
		StatementChecker statementchecker = new StatementChecker(new TypeEnvironment(), problems);
		form.accept(statementchecker);
	}
	
	private Form parseDSL(String inputDSL) throws ParseException{
		return (Form) parser.parser(inputDSL);
	}
	
}
