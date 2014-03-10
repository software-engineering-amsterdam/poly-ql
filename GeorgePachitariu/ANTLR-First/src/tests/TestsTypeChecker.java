package tests;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import parser.QLParser;
import typeChecker.BooleanConditionsChecker;
import typeChecker.CyclicDependenciesChecker;
import typeChecker.DuplicateLabelsChecker;
import typeChecker.DuplicatedIdentifierChecker;
import typeChecker.InvalidTypeOperandsChecker;
import typeChecker.UndefinedIdentifierChecker;
import types.BoolType;
import types.MoneyType;
import expr.Expression;
import expr.Ident;
import expr.arithmetic.Sub;
import expr.literals.Bool;
import expr.relational.Eq;
import expr.syntactic.Form;
import expr.syntactic.Question;
import expr.syntactic.QuestionBody;

public class TestsTypeChecker {

	@Test
	public void undefinedIdentifierChecker_0Undefined() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"privateDebt: \"Private debts for the sold house:\" money " +
						"valueResidue: \"Value residue:\" money(sellingPrice - privateDebt) "+
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<Ident> actual = new UndefinedIdentifierChecker().check(ast);
		List<Ident> expected=new LinkedList<>();

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void undefinedIdentifierCheckerWith_2Undefined() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (undef) { " +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"privateDebt: \"Private debts for the sold house:\" money " +
						"valueResidue: \"Value residue:\" money(sellingPrice - debt) "+
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<Ident> actual = new UndefinedIdentifierChecker().check(ast);

		List<Ident> expected=new LinkedList<>();
		expected.add(new Ident("undef"));
		expected.add(new Ident("debt"));

		Assert.assertEquals(expected, actual);
	}


	@Test
	public void duplicatedIdentifierChecker_0Duplicates() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"privateDebt: \"Private debts for the sold house:\" money " +
						"valueResidue: \"Value residue:\" money(sellingPrice - privateDebt) "+
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<Question> actual = new DuplicatedIdentifierChecker().check(ast);
		List<Question> expected=new LinkedList<>();

		Assert.assertEquals(expected, actual);
	}


	@Test
	public void duplicatedIdentifierChecker_1Duplicate() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"hasSoldHouse: \"Private debts for the sold house:\" money " +
						"privateDebt: \"Value residue:\" boolean(sellingPrice - privateDebt) "+
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<Question> actual = new DuplicatedIdentifierChecker().check(ast);

		List<Question> expected=new LinkedList<>();
		expected.add (new Question(new Ident("hasSoldHouse"),
				new QuestionBody("\"Did you sell a house in 2010?\""), new BoolType()));
		expected.add (new Question(new Ident("hasSoldHouse"),
				new QuestionBody("\"Private debts for the sold house:\""), new MoneyType()));

		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void booleanConditionsChecker_0WrongConditions() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" money "+
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<String> actual = new BooleanConditionsChecker().check(ast);

		List<Expression> expected=new LinkedList<>();

		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void booleanConditionsChecker_1WrongConditions() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" money " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" money "+
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<String> actual = new BooleanConditionsChecker().check(ast);

		List<String> expected=new LinkedList<>();
		expected.add("hasSoldHouse");

		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void invalidTypeOperandsChecker_0WrongOperands() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"if (hasSoldHouse == true && (sellingPrice < 1000)) { " +
						"privateDebt: \"Private debts for the sold house:\" integer " +
						"result: \"Value residue:\" boolean(sellingPrice - privateDebt) "+
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<Expression> actual = new InvalidTypeOperandsChecker().check(ast);

		List<Expression> expected=new LinkedList<>();

		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void invalidTypeOperandsChecker_2WrongOperands() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" money " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"if (hasSoldHouse == true && (sellingPrice < 1000)) { " +
						"privateDebt: \"Private debts for the sold house:\" money " +
						"result: \"Value residue:\" boolean(sellingPrice - privateDebt) "+
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<Expression> actual = new InvalidTypeOperandsChecker().check(ast);

		List<Expression> expected=new LinkedList<>();
		expected.add(new Eq(new Ident("hasSoldHouse"), new Bool(true)));
		expected.add(new Sub(new Ident("sellingPrice"), new Ident("privateDebt")));

		Assert.assertEquals(expected, actual);
	}


	@Test 
	public void duplicateLabelsChecker_1WrongLabels() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" money " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"hasSoldHouse: \"Private debts for the sold house:\" money " +
						"result: \"Value residue:\" boolean(sellingPrice - privateDebt) "+
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<Ident> actual = new DuplicateLabelsChecker().check(ast);

		List<Ident> expected=new LinkedList<>();
		expected.add(new Ident("hasSoldHouse"));

		Assert.assertEquals(expected, actual);
	}


	@Test 
	public void cyclicDependenciesChecker_NoCycle() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" money " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"hasSoldHouse: \"Private debts for the sold house:\" money " +
						"result: \"Value residue:\" boolean(sellingPrice - privateDebt) "+
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<Question> actual = new CyclicDependenciesChecker().check(ast);

		List<Question> expected=new LinkedList<>();

		Assert.assertEquals(expected, actual);
	}

	@Test 
	public void cyclicDependenciesChecker_WithCycle() throws RecognitionException {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean(sellingPrice == true) " +
						"sellingPrice: \"Price the house was sold for:\" boolean(hasSoldHouse == result) " +
						"result: \"Private debts for the sold house:\" boolean " +
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);
		Form ast=parser.form().result;			
		List<Question> actual = new CyclicDependenciesChecker().check(ast);

		List<Question> expected=new LinkedList<>();

		Assert.assertNotSame(expected, actual);
	}
}
