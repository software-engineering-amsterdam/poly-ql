package tests;

import junit.framework.Assert;

import nodeAST.syntactic.Form;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;


import parser.QLParser;
import typeChecker.BooleanConditions;
import typeChecker.CyclicDependencies;
import typeChecker.DuplicateLabels;
import typeChecker.DuplicatedIdentifier;
import typeChecker.InvalidTypeOperands;
import typeChecker.UndefinedIdentifier;

public class FunctionalTestsTypeChecker {

	@Test
	public void undefinedIdentifierChecker_0Undefined() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"privateDebt: \"Private debts for the sold house:\" integer " +
						"valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt) "+
						" } } "; 


		QLParser parser=ASTNodes.getParser(str);
		Form ast=parser.form().result;
		
		try {
			new UndefinedIdentifier().check(ast);
			Assert.assertTrue(true); 
		} catch (Exception e) {
			Assert.assertTrue(false); 
		}
	}

	@Test
	public void undefinedIdentifierCheckerWith_1Undefined() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (undef) { " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						" } } "; 


		QLParser parser=ASTNodes.getParser(str);
		Form ast=parser.form().result;			
		

		try {
			new UndefinedIdentifier().check(ast);
			Assert.assertTrue(false); 
		} catch (Exception e) {
			String actual = e.getMessage();
			String expected = "ERROR: The following references are not defined: undef, ";
			Assert.assertTrue(actual.equals(expected)); 
		}		
	}


	@Test
	public void duplicatedIdentifierChecker_0Duplicates() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"privateDebt: \"Private debts for the sold house:\" integer " +
						"valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt) "+
						" } } "; 


		QLParser parser=ASTNodes.getParser(str);
		Form ast=parser.form().result;			
		
		try {
			new DuplicatedIdentifier().check(ast);
			Assert.assertTrue(true); 
		} catch (Exception e) {
			Assert.assertTrue(false); 
		}
	}


	@Test
	public void duplicatedIdentifierChecker_1Duplicate() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (hasSoldHouse) { " +
						"hasSoldHouse: \"Private debts for the sold house:\" integer " +
						" } } "; 


		QLParser parser=ASTNodes.getParser(str);
		Form ast=parser.form().result;			
		
		try {
			new DuplicatedIdentifier().check(ast);
			Assert.assertTrue(false); 
		} catch (Exception e) {
			String actual = e.getMessage();
			String expected = "ERROR: The following questions have the same question declaration but with different types \n"+
					"hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n"+
					"hasSoldHouse: \"Private debts for the sold house:\" integer\n";
			Assert.assertTrue(actual.equals(expected)); 
		}	
	}

	@Test 
	public void booleanConditionsChecker_1WrongConditions() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" integer " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" integer "+
						"}  } "; 


		QLParser parser=ASTNodes.getParser(str);
		Form ast=parser.form().result;			
		
		try {
			new BooleanConditions().check(ast);
			Assert.assertTrue(false); 
		} catch (Exception e) {
			String actual = e.getMessage();
			String expected="ERROR: The following conditions contained in 'if' structures should " +
					"be of type boolean but are not: \nhasSoldHouse\n";
			Assert.assertTrue(actual.equals(expected)); 
		}	

	}

	@Test 
	public void invalidTypeOperandsChecker_1WrongOperand() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" integer " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"if (hasSoldHouse == true && (sellingPrice < 1000)) { " +
						"privateDebt: \"Private debts for the sold house:\" integer " +
						" } } "; 


		QLParser parser=ASTNodes.getParser(str);
		Form ast=parser.form().result;			
		
		try {
			new InvalidTypeOperands().check(ast);
			Assert.assertTrue(false); 
		} catch (Exception e) {
			Assert.assertTrue(true); 
		}	
	}


	@Test 
	public void duplicateLabelsChecker_1WrongLabels() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" integer " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"hasSoldHouse: \"Private debts for the sold house:\" integer " +
						"result: \"Value residue:\" boolean(sellingPrice - privateDebt) "+
						" } "; 


		QLParser parser=ASTNodes.getParser(str);
		Form ast=parser.form().result;

		try {
			new DuplicateLabels().check(ast);
			Assert.assertTrue(true); 
		} catch (Exception e) {
			Assert.assertTrue(false); 
		}	
	}


	@Test 
	public void cyclicDependenciesChecker_WithCycle() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean(sellingPrice == true) " +
						"sellingPrice: \"Price the house was sold for:\" boolean(hasSoldHouse == result) " +
						"result: \"Private debts for the sold house:\" boolean " +
						" } } "; 


		QLParser parser=ASTNodes.getParser(str);
		Form ast=parser.form().result;
		try {
			new CyclicDependencies().check(ast);
			Assert.assertTrue(false); 
		} catch (Exception e) {
			Assert.assertTrue(true); 
		}
	}
}
