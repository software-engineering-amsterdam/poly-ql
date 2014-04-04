package ql.tests;

import junit.framework.Assert;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;


import ql.ast.checker.BooleanConditions;
import ql.ast.checker.CyclicDependencies;
import ql.ast.checker.DuplicatedIdentifier;
import ql.ast.checker.InvalidTypeOperands;
import ql.ast.checker.UndefinedIdentifier;
import ql.ast.node.syntactic.Form;
import ql.grammar.QLParser;

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

		String s=new UndefinedIdentifier().check(ast);
		Assert.assertTrue(s!=null);
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
		String s=new DuplicatedIdentifier().check(ast);
		Assert.assertTrue(s==null);
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

		String s=new DuplicatedIdentifier().check(ast);
		Assert.assertTrue(s!=null);
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

		String s=new BooleanConditions().check(ast);
		Assert.assertTrue(s!=null);

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

		String s=new InvalidTypeOperands().check(ast);
		Assert.assertTrue(s!=null);
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
		String s=new CyclicDependencies().check(ast);
		Assert.assertTrue(s!=null);
	}
}
