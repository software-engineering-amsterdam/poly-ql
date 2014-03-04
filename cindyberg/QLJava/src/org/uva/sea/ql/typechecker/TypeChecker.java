package org.uva.sea.ql.typechecker;

import java.util.ArrayList;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.jacc.Parser;

/* 
 cyclic dependencies between questions
*/
public class TypeChecker {
	
	private Problems problems;
	private Parser parser;

	public TypeChecker(){ 
		parser = new Parser();
		
	}
	
	@Test
	public void testForms(){
		String form1 = "form FORM { Var : \"label\" integer }";
		System.out.println("\n check form1... \n");
		checkDSL(form1);
		String form2 = "form FORM { Var : \"label\" boolean (1+1)}";
		System.out.println("\n check form2... \n");
		checkDSL(form2);
		String form3 = "form FORM {Var : \"this is a question\" boolean \n"
				+ "if(Var) { Calc : \"Calculate this\" integer (1+1)} }";
		System.out.println("\n check form3... \n");
		checkDSL(form3);
		String form4 = "form FORM {Var: \"made 1\" boolean \n"
				+ "Var: \"declaring again\" integer }"; 
		System.out.println("\n check form4... \n");
		checkDSL(form4);
		String form5 = "form FORM {Var: \"testing\" integer (1+Hallo) "
				+ "if(Var) {"
				+ "Calc: \" should not work\" boolean "
				+ "Calc2 : \"also false\" integer (1+Calc2) "
				+ "Calc : \"hihi\" boolean }"
				+ "else{ "
				+ " Vari : \"bool\" integer "
				+ " Vari2 : \"bool\" boolean "
				+ " Vari3 : \"bool\" boolean (Vari&&Vari2)} }"; 
		System.out.println("\n check form5... \n ");
		checkDSL(form5);	
		
	}
	public void checkDSL(String inputDSL){
		Form tree = (Form) parser.parser(inputDSL);
		problems = new Problems(new ArrayList<String>(),new ArrayList<String>());
		StatementChecker statementchecker = new StatementChecker(new TypeEnvironment(), problems);
		tree.accept(statementchecker);

		printProblems();

	}
	
	private void printProblems(){
		problems.printErrors();
		problems.printWarnings();
	}
	
}
