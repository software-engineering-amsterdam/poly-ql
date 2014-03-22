package tests;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import nodeAST.Ident;
import nodeAST.arithmetic.Sub;
import nodeAST.syntactic.Form;
import nodeAST.syntactic.IfBlock;
import nodeAST.syntactic.IfElseBlock;
import nodeAST.syntactic.Question;
import nodeAST.syntactic.QuestionBody;
import nodeAST.syntactic.Statement;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;


import parser.QLParser;
import types.BoolType;
import types.IntType;

public class FunctionalTestsSyntacticExpr {

	private String getQuestionString1() {
		return "hasSoldHouse: \"Did you sell a house in 2010?\" boolean";
	}

	private Question getQuestion1() {
		return new Question(new Ident("hasSoldHouse"),
				new QuestionBody("\"Did you sell a house in 2010?\""),
				new BoolType());
	}

	@Test
	public void testQuestion() throws RecognitionException  {
		String str=getQuestionString1();
		QLParser parser=ASTNodes.getParser(str);

		Question actual=parser.question().result;

		Question expected=getQuestion1();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testQuestionWithExpression() throws RecognitionException  {
		String str="valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt)";
		QLParser parser=ASTNodes.getParser(str);

		Question actual=parser.question().result;

		Question expected=new Question(new Ident("valueResidue"),
				new QuestionBody("\"Value residue:\""),
				new IntType(), new Sub(new Ident("sellingPrice"),new Ident("privateDebt")));
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIfBlockSimple() throws RecognitionException  {
		String str="if (hasSoldHouse) { " + getQuestionString1() + "}";
		QLParser parser=ASTNodes.getParser(str);

		IfBlock actual=parser.if_block().result;

		Question q=getQuestion1();
		List<Statement> list=new LinkedList<>();
		list.add(q);
		IfBlock expected=new IfBlock(new Ident("hasSoldHouse"),list);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIfBlockWithElse() throws RecognitionException  {
		String str="if (hasSoldHouse) { " + getQuestionString1() +
				" else { " + getQuestionString1() + " } }";
		QLParser parser=ASTNodes.getParser(str);
		IfBlock actual=parser.if_block().result;

		List<Statement> list=new LinkedList<>();
		list.add(getQuestion1());
		List<Statement> list2=new LinkedList<>();
		list2.add(getQuestion1());

		IfElseBlock expected=new IfElseBlock(new Ident("hasSoldHouse"),list,list2);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testForm() throws RecognitionException  {
		String str="	form Box1HouseOwning { " + getQuestionString1() + "}";

		QLParser parser=ASTNodes.getParser(str);
		Form actual=parser.form().result;

		List<Statement> list=new LinkedList<>();
		list.add(getQuestion1());
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
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"privateDebt: \"Private debts for the sold house:\" integer " +
						"valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt) " +
						"} else { " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"} }";

		QLParser parser=ASTNodes.getParser(str);
		Form tree1=parser.form().result;

		parser=ASTNodes.getParser( tree1.toString() );
		Form tree2=parser.form().result;

		Assert.assertTrue(tree1.equals(tree2));
	}
}
