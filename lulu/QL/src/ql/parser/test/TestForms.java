package ql.parser.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import ql.ast.form.ComputedQuestion;
import ql.ast.form.Form;
import ql.ast.form.FormItems;
import ql.ast.form.Question;
import ql.parser.antlr.FormParser;


public class TestForms {

	FormParser parser = new FormParser();
	private String form1 = "form testForm {\n" +
								"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
								"hasBoughtHouse: \"Have you bought a house in 2012?\" boolean\n" +
								"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean(true)\n" +
								"}\n";
	
	private String form2 = "form testForm {\n" +
			"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
			"hasBoughtHouse: \"Have you bought a house in 2012?\" boolean\n" +
			"hasSoldHouse: \"Did you enter a loan for maintenance/reconstruction?\" int\n" +
			"}\n";
	
	private String form3 = "form testForm {\n" +
			"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
			"hasBoughtHouse: \"Have you bought a house in 2012?\" boolean(false)\n" +
			"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean(hasSoldHouse)\n" +
			"}\n";
	
	private String form4 = "form testForm {\n" +
			"hasSoldHouse: \"Have you sold a house in 2012?\" boolean(true)\n" +
			"hasBoughtHouse: \"Have you bought a house in 2012?\" boolean(false)\n" +
			"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean(2)\n" +
			"}\n";
	
	private String form5 = "form testForm {\n" +
			"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
			"	if (hasSoldHouse) {\n" +
			"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
			"	}\n" +
			"	else {\n" +
			"		totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
			"	}\n" +
			"}\n";
	
	private String form6 = "form testForm {\n" +
			"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
			"	if (hasSoldHouse) {\n" +
			"		totalSoldHouseValue: \"How much money did you get for all houses in total?\" int\n" +
			"		if (totalSoldHouseValue) {\n" +
			"			yuRich: \"Do you consider yourself rich?\" boolean\n" +
			"		}\n" +
			"	}\n" +
			"}\n";
	
	@Test 
	public void testFormParser() throws ParseError, IOException {
		assertEquals(parser.parseForm(form1).getClass(),Form.class);
		assertEquals(parser.parseForm(form1).getFormItems().size(),3);
		assertEquals(parser.parseForm(form1).getFormItems().get(2).getClass(),ComputedQuestion.class);		
	}
	
	@Test
	public void testQuestionType() throws ParseError, IOException {
		Question q1 = (Question) parser.parseForm(form1).getFormItems().get(0);
		Question q2 = (Question) parser.parseForm(form1).getFormItems().get(1);
		assertEquals(q1.getType().getClass(),q2.getType().getClass());
	}
	
	@Test
	public void testFormIdents() throws ParseError, IOException {
		assertTrue(parser.parseForm(form1).validate());
		assertFalse(parser.parseForm(form2).validate());
		assertTrue(parser.parseForm(form3).validate());
		assertFalse(parser.parseForm(form4).validate());
	}
	
	@Test
	public void testFormStatement() throws ParseError, IOException {
		assertEquals(parser.parseForm(form1).getFormItems().size(),3);
		assertTrue(parser.parseForm(form5).validate());
		assertFalse(parser.parseForm(form6).validate());
	}
}