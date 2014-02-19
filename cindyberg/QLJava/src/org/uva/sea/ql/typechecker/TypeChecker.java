package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.jacc.Parser;

public class TypeChecker {
	
	List<Error> errorlist; 
	TypeEnvironment environment; 
	Parser parser;

	public TypeChecker(){ 
		parser = new Parser();
		
	}
	
	@Test
	public void checkDSL(){
		String inputDSL = "form F { NieuwVar : \"lala\" boolean \n"
				+ "if(NieuwVar){HasMoney : \"ILIKEMONEY\" integer } }";
		Form tree = (Form) parser.parser(inputDSL);
		
		errorlist = new ArrayList<Error>();
		StatementChecker statementchecker = new StatementChecker(new TypeEnvironment(), errorlist);
		tree.accept(statementchecker);
		
		if(errorlist != null){
			System.out.println("Aantal fouten gevonden: [" + errorlist.size() + "]");
			printErrors();
		}
		else{
			System.out.println("Aantal fouten gevonden: [0]");
			System.out.println("no errors in file!");
		}
	}
	
	public void printErrors(){
		for(Error e : errorlist){
			System.out.println(e.error);
		}
	}
}
