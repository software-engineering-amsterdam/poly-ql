package org.uva.sea.ql.gui;

import java.io.FileNotFoundException;

import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.jacc.ParseException;
import org.uva.sea.ql.parser.jacc.Parser;
import org.uva.sea.ql.typechecker.StatementChecker;
import org.uva.sea.ql.typechecker.TypeEnvironment;

import problems.Problems;

public class StartScreenController {
	
	private Parser parser;
	private Problems problems;
	
	public StartScreenController(){
		
		this.parser = new Parser();
		this.problems = new Problems();
		
	}

	public Problems runTypeChecker(String INPUT) throws FileNotFoundException, ParseException {
		checkDSL(parseDSL(INPUT));
		return problems;	
	}
	
	private void checkDSL(Form form) throws ParseException{
		StatementChecker statementchecker = new StatementChecker(new TypeEnvironment(), problems);
		form.accept(statementchecker);
	}
	
	private Form parseDSL(String inputDSL) throws ParseException{
		return (Form) parser.parser(inputDSL);
	}
	

}
