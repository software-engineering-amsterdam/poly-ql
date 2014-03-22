package maintest;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.*;

import typecheck.ErrorList;
import typecheck.SymbolTable;
import typecheck.TypeChecker;
import antlr.QLangLexer;
import antlr.QLangParser;
import ast.ASTNode;

public class TypeCheckerTest {
	
	public void test(boolean expected, String str){
		ANTLRInputStream input = new ANTLRInputStream(str);
		QLangLexer lexer = new QLangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLangParser parser = new QLangParser(tokens);
		ASTNode tree = parser.form().result;
				
		SymbolTable symb = new SymbolTable();
		ErrorList errors= new ErrorList();
		TypeChecker checker = new TypeChecker(symb, errors);
		boolean result = checker.check_symb(tree, symb, errors);
		if(!result) System.out.print(checker.get_errorList());
		assertEquals(expected, result);
		
	}
	
	@Test
	public void testForm(){
		System.out.println("Start testing testForm");
		test(true, "form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean"+
				"\nif (hasSoldHouse == false) {"+
				"\nsellingPrice: \"Price the house was sold for:\" integer"+
				"\nprivateDebt: \"Private debts for the sold house:\" integer"+
				"\nvalueResidue: \"Value residue:\" integer(sellingPrice - privateDebt) } \n" +
				"\n else { valueResidue1: \"Value residue:\" integer(sellingPrice + privateDebt )}}");
		test(true, "form form1 { sellingPrice: \"Price the house was sold for:\" integer" + 
				"\nif(sellingPrice > 1000){" +
				"\nprivateDebt: \"Private debts for the sold house:\" integer }}");
		test(false, "form form1 { sellingPrice: \"Price the house was sold for:\" integer" + 
				"\nif(sellingPrice > 1000){" +
				"\nsellingPrice: \"Private debts for the sold house:\" integer }}");
		
		test(true, "form form1 { sellingPrice: \"Price the house was sold for:\" integer" + 
				"\nif(true){" +
				"\nprivateDebt: \"Private debts for the sold house:\" integer }}");
		
	}
	
	@Test
	public void testLiterals(){
		System.out.println("\nStart testing testLiterals");
		test(true, "form form1 { q1 : \"a question\" integer(4) }");
		test(false, "form form1 { q1 : \"a question\" integer(true) }");
		test(false, "form form1 { q1 : \"a question\" integer(\"1\") }");
		test(true, "form form1 { q1 : \"a question\" boolean(false) }");
		test(false, "form form1 { q1 : \"a question\" boolean(\" hh\") }");
		test(false, "form form1 { q1 : \"a question\" boolean(12) }");
		test(true, "form form1 { id1: \"Value?\" string(\"abc\") }");
		test(false, "form form1 { id1: \"Value?\" string(123) }");
		test(false, "form form1 { id1: \"Value?\" string(true) }");
		test(false, "form form1 { q1 : \"a question\" integer(1)" +
				"\nq1 : \"a question\" boolean(true) }");
	}
	
	@Test
	public void testBinExpr(){
		System.out.println("\nStart testing testBinExpr");
		test(true, "form form1 { q1 : \"a question\" integer(4 + 2) }");
		test(false, "form form1 { q1 : \"a question\" integer(4 + (3 - true) * 2) }");
		test(false, "form form1 { q1 : \"a question\" integer(17 / false)}");
		test(true, "form form1 { q1 : \"a question\" boolean(true && true) }");
		test(false, "form form1 { q1 : \"a question\" boolean( false || 1) }");
		test(true, "form form1 { q1 : \"a question\" boolean(false || false) }");
		test(false, "form form1 { q1 : \"a question\" boolean(false || test) }");
	}
	
	@Test
	public void testUnExpr(){
		System.out.println("\nStart testing testUnExpr");
		test(true, "form form1 { q1 : \"a question\" boolean(!q1)}");
		test(true, "form form1 { q1 : \"a question\" integer(+q1)}");
		test(false, "form form1 { q1 : \"a question\" boolean(!1)}");
		test(false, "form form1 { q1 : \"a question\" boolean(!test)}");
		test(true, "form form1 { q1 : \"a question\" integer(-q1)}");
		test(false, "form form1 { q1 : \"a question\" boolean(-true)}");
	}
	
	@Test
	public void testIfstatement(){
		System.out.println("\nStart testing testIfstatement");
		test(true, "form form1 { x : \"a question\" boolean"+
					"\nif(x == true) {q1 : \"a question\" boolean(true)}}");
		test(false, "form form1 { x : \"a question\" boolean"+
				"\nif(x == 1) {q1 : \"a question\" boolean(true)}}");
		test(false, "form form1 { x : \"a question\" boolean"+
				"\nif(x == test) {q1 : \"a question\" boolean(true)}}");
		test(true, "form form1 { x : \"a question\" integer"+
				"\nif(x >= 1) {q1 : \"a question\" boolean(true)}}");
		test(true, "form form1 { x : \"a question\" boolean"+
				"\nif(!x != true) {q1 : \"a question\" boolean(true)}}");
		test(false, "form form1 { x : \"a question\" integer"+
			"\nif(x < bla) {q1 : \"a question\" boolean(true)}}");
		test(false, "form form1 { x : \"a question\" integer"+
				"\nif(x + 5) {q1 : \"a question\" boolean(true)}}");
	}
	
	@Test
	public void testIfElsestatement(){
		System.out.println("\nStart testing testIfElseStatement");
		test(true, "form form1 { x : \"a question\" boolean"+
				"\nif(x == true) {q1 : \"a question\" boolean(true)}"+
		"\nelse{q2 : \"a question2\" boolean}}");
		test(false, "form form1 { x : \"a question\" boolean"+
				"\nif(x == true) {q1 : \"a question\" boolean(true)}"+
		"\nelse{q1 : \"a question2\" boolean(true)}}");
		test(false, "form form1 { x : \"a question\" boolean"+
				"\nif(x > 5) {q1 : \"a question\" boolean(true)}"+
		"\nelse{q2 : \"a question2\" boolean}}");		
	}
	
}
