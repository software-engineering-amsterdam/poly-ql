package tests;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import parser.QLParser;
import types.BoolType;
import types.MoneyType;
import expr.Ident;
import expr.arithmetic.Sub;
import expr.syntactic.Form;
import expr.syntactic.IfBlock;
import expr.syntactic.Question;
import expr.syntactic.QuestionBody;
import expr.syntactic.Statement;

public class TestsFunctSyntacticExpr {

	private String getQuestionString1() {
		return "hasSoldHouse: \"Did you sell a house in 2010?\" boolean";
	}

	private Question getQuestionObject1() {
		return new Question(new Ident("hasSoldHouse"),
				new QuestionBody("\"Did you sell a house in 2010?\""),
				new BoolType());
	}

	@Test
	public void testQuestion() throws RecognitionException  {
		String str=getQuestionString1();
		QLParser parser=TestsExpr.getParser(str);

		Question actual=parser.question().result;

		Question expected=getQuestionObject1();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testQuestionWithExpression() throws RecognitionException  {
		String str="valueResidue: \"Value residue:\" money(sellingPrice - privateDebt)";
		QLParser parser=TestsExpr.getParser(str);

		Question actual=parser.question().result;

		Question expected=new Question(new Ident("valueResidue"),
				new QuestionBody("\"Value residue:\""),
				new MoneyType(), new Sub(new Ident("sellingPrice"),new Ident("privateDebt")));
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIfBlockSimple() throws RecognitionException  {
		String str="if (hasSoldHouse) { " +
				" sellingPrice: \"Price the house was sold for:\" money " +
				" privateDebt: \"Private debts for the sold house:\" money }" ;
		QLParser parser=TestsExpr.getParser(str);

		IfBlock actual=parser.if_block().result;


		Question q1=new Question(new Ident("sellingPrice"),
				new QuestionBody("\"Price the house was sold for:\""),
				new MoneyType());
		Question q2=new Question(new Ident("privateDebt"),
				new QuestionBody("\"Private debts for the sold house:\""),
				new MoneyType());

		List<Statement> list=new LinkedList<>();
		list.add(q1);
		list.add(q2);
		IfBlock expected=new IfBlock(new Ident("hasSoldHouse"),list);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIfBlockWithElse() throws RecognitionException  {
		String str="if (hasSoldHouse) { " +
				" sellingPrice: \"Price the house was sold for:\" money " +
				" privateDebt: \"Private debts for the sold house:\" money }" +
				" else { " +
				" privateDebt: \"Private debts for the sold house:\" money " +
				" sellingPrice: \"Price the house was sold for:\" money }";
		QLParser parser=TestsExpr.getParser(str);

		IfBlock actual=parser.if_block().result;


		Question q1=new Question(new Ident("sellingPrice"),
				new QuestionBody("\"Price the house was sold for:\""),
				new MoneyType());
		Question q2=new Question(new Ident("privateDebt"),
				new QuestionBody("\"Private debts for the sold house:\""),
				new MoneyType());

		List<Statement> list=new LinkedList<>();
		list.add(q1);
		list.add(q2);
		List<Statement> list2=new LinkedList<>();
		list2.add(q2);
		list2.add(q1);

		IfBlock expected=new IfBlock(new Ident("hasSoldHouse"),list,list2);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testForm() throws RecognitionException  {
		String str=
				"	form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"privateDebt: \"Private debts for the sold house:\" money " +
						" } } "; 


		QLParser parser=TestsExpr.getParser(str);

		Form actual=parser.form().result;


		Question q3=new Question(new Ident("sellingPrice"),
				new QuestionBody("\"Price the house was sold for:\""),
				new MoneyType());
		Question q4=new Question(new Ident("privateDebt"),
				new QuestionBody("\"Private debts for the sold house:\""),
				new MoneyType());

		List<Statement> list2=new LinkedList<>();
		list2.add(q3);
		list2.add(q4);		
		Statement ifBlock=new IfBlock(new Ident("hasSoldHouse"),list2);

		List<Statement> list=new LinkedList<>();
		list.add(getQuestionObject1());
		list.add(ifBlock);

		Form expected=new Form(new Ident("Box1HouseOwning"),list);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testToStringMethods() throws RecognitionException  {
		// tree1.build(string);
		// tree2.build( tree1.toString() );
		// assert(tree1==tree2);

		String str=
				"form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"privateDebt: \"Private debts for the sold house:\" money " +
						"valueResidue: \"Value residue:\" money(sellingPrice - privateDebt) " +
						"} else { " +
						"sellingPrice: \"Price the house was sold for:\" money " +
						"} }";

		QLParser parser=TestsExpr.getParser(str);
		Form tree1=parser.form().result;

		parser=TestsExpr.getParser( tree1.toString() );
		Form tree2=parser.form().result;

		Assert.assertTrue(tree1.equals(tree2));
	}
}
