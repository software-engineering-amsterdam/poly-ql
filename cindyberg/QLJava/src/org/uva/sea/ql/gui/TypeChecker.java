package org.uva.sea.ql.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.jacc.ParseException;
import org.uva.sea.ql.parser.jacc.Parser;
import org.uva.sea.ql.typechecker.StatementChecker;
import org.uva.sea.ql.typechecker.TypeEnvironment;

import problems.Problems;

public class TypeChecker {

	private Problems problems;
	private Parser parser;
	
	public TypeChecker(){
		parser = new Parser();
		problems = new Problems();
		
	}
	
	public Problems run(String INPUT) throws FileNotFoundException, ParseException{
		Scanner input =  new Scanner(new File(INPUT));
		String DSLFORM = "" ;
		while(input.hasNextLine()){

			String line = input.nextLine();
			DSLFORM = DSLFORM + '\n' + line;

		}
		input.close();
		checkDSL(DSLFORM);
		return problems;
	}
	
	
	public void checkDSL(String inputDSL) throws ParseException{
		Form tree = (Form) parser.parser(inputDSL);
		StatementChecker statementchecker = new StatementChecker(new TypeEnvironment(), problems);
		tree.accept(statementchecker);
	}
}
