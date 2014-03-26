package ql.parser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import ql.parser.antlr.FormParser;

public class TypeChecker {
	FormParser parser = new FormParser();
	
	@Test 
	//reference to undefined questions
	public void testUndefQuestion() throws ParseError, IOException {
		assertTrue(parser.parseForm(
				"form testForm {\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"hasBoughtHouse: \"Have you bought a house in 2012?\" boolean\n" +
						"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean(hasSoldHouse)\n" +
						"}\n"
						).validate());
		
		assertFalse(parser.parseForm(
				"form testForm {\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"hasBoughtHouse: \"Have you bought a house in 2012?\" boolean\n" +
						"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean(undefinedTest)\n" +
						"}\n"
						).validate());
		
		assertTrue(parser.parseForm(
				"form testForm {\n" +
						"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"	if (hasSoldHouse) {\n" +
						"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"	else {\n" +
						"		totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"}\n"
						).validate());
		
		assertFalse(parser.parseForm(
				"form testForm {\n" +
						"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"	if (undefinedTest) {\n" +
						"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"	else {\n" +
						"		totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"}\n"
						).validate());
	}
	
	@Test
	//duplicate question declarations with different types
	public void testDupQuestion() throws ParseError, IOException {
		assertTrue(parser.parseForm(
				"form testForm {\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean(hasSoldHouse)\n" +
						"}\n"
						).validate());
		
		assertFalse(parser.parseForm(
				"form testForm {\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" int\n" +
						"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean(hasSoldHouse)\n" +
						"}\n"
						).validate());
	}
	
	@Test
	//conditions that are not of the type boolean
	public void testCondition() throws ParseError, IOException {
		assertTrue(parser.parseForm(
				"form testForm {\n" +
						"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"	if (hasSoldHouse) {\n" +
						"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"	else {\n" +
						"		totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"}\n"
						).validate());
		
		assertTrue(parser.parseForm(
				"form testForm {\n" +
						"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"	if (true) {\n" +
						"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"	else {\n" +
						"		totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"}\n"
						).validate());
		
		assertFalse(parser.parseForm(
				"form testForm {\n" +
						"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"	if (\"aa\") {\n" +
						"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"	else {\n" +
						"		totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"}\n"
						).validate());
		
		assertFalse(parser.parseForm(
				"form testForm {\n" +
						"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"	if (2) {\n" +
						"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"	else {\n" +
						"		totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"}\n"
						).validate());
		
		assertFalse(parser.parseForm(
				"form testForm {\n" +
						"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"	if (undefinedTest) {\n" +
						"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"	else {\n" +
						"		totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"}\n"
						).validate());
	}
	
	@Test
	//operands of invalid type to operators
	public void testOperands() throws ParseError, IOException {
		assertTrue(parser.parseForm(
				"form testForm {\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean(true || (4 > 2))\n" +
						"}\n"
						).validate());
		
		assertTrue(parser.parseForm(
				"form testForm {\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"valueResidue: \"Value residue:\" int((6+3) - 1*2)\n" +
						"}\n"
						).validate());
		
		assertFalse(parser.parseForm(
				"form testForm {\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"valueResidue: \"Value residue:\" int((6*3) - a)\n" +
						"}\n"
						).validate());
		
		assertFalse(parser.parseForm(
				"form testForm {\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"valueResidue: \"Value residue:\" int(hasSoldHouse-2)\n" +
						"}\n"
						).validate());
		
		assertTrue(parser.parseForm(
				"form testForm {\n" +
						"hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean(true || hasSoldHouse)\n" +
						"}\n"
						).validate());
	}
	
	@Test
	//cyclic dependencies between questions
	public void testDependency() throws ParseError, IOException {
		assertTrue(parser.parseForm(
				"form testForm {\n" +
						"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"	if (hasSoldHouse) {\n" +
						"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"		if (totalSoldHouseValue) {\n" +
						"			totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"		}\n" +
						"	}\n" +
						"}\n"
						).validate());
		
		assertFalse(parser.parseForm(
				"form testForm {\n" +
						"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"	if (hasSoldHouse) {\n" +
						"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"	if (totalSoldHouseValue) {\n" +
						"		totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"}\n"
						).validate());
		
		assertFalse(parser.parseForm(
				"form testForm {\n" +
						"	hasSoldHouse: \"Have you sold a house in 2012?\" boolean\n" +
						"	if (totalSoldHouseValue2) {\n" +
						"		totalSoldHouseValue: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"	if (totalSoldHouseValue) {\n" +
						"		totalSoldHouseValue2: \"Was house sold?\" boolean(hasSoldHouse)\n" +
						"	}\n" +
						"}\n"
						).validate());
	}
}
