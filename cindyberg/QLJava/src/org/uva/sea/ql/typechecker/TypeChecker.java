package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.parser.jacc.Parser;

/* 
??reference to undefined questions
   !!duplicate question declarations with different types
   !!conditions that are not of the type boolean
   !!operands of invalid type to operators
??references to questions with an undefined value
cyclic dependencies between questions
   !!duplicate labels (warning)
*/
public class TypeChecker {
	
	List<Error> errorlist; 
	TypeEnvironment environment; 
	Parser parser;

	public TypeChecker(){ 
		parser = new Parser();
		
	}
	
	@Test
	public void testForms(){
		String form1 = "form FORM { Var : \"label\" integer }";
		System.out.println("check form1...");
		checkDSL(form1);
		String form2 = "form FORM { Var : \"label\" boolean (1+1)}";
		System.out.println("check form2...");
		checkDSL(form2);
		String form3 = "form FORM {Var : \"this is a question\" boolean \n"
				+ "if(Var) { Calc : \"Calculate this\" integer (1+1)} }";
		System.out.println("check form3...");
		checkDSL(form3);
		String form4 = "form FORM {Var: \"made 1\" boolean \n"
				+ "Var: \"declaring again\" integer }"; 
		System.out.println("check form4...");
		checkDSL(form4);
		String form5 = "form FORM {Var: \"testing\" integer (1+Hallo) "
				+ "if(Var) {"
				+ "Calc: \" should not work\" boolean "
				+ "Calc2 : \"also false\" integer (1+Calc) "
				+ "Calc : \"hihi\" boolean }"
				+ "else{ "
				+ " Vari : \"bool\" integer "
				+ " Vari2 : \"bool\" boolean "
				+ " Vari3 : \"bool\" boolean (Vari&&Vari2)} }";  //still having problems with keywords true and false
		System.out.println("check form5...");
		checkDSL(form5);	
		
	}
	public void checkDSL(String inputDSL){
		Form tree = (Form) parser.parser(inputDSL);
		System.out.println(tree);
		System.out.println(inputDSL);
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
