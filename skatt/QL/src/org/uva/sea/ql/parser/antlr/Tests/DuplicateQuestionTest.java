package org.uva.sea.ql.parser.antlr.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.Messages.DuplicateQuestionError;

public class DuplicateQuestionTest extends QL4Test {
	
	@BeforeClass
	public static void init() {
		setFile("test/duplicateQuestionTest");
	}
	
	@Test
	public void testDuplicateQuestion() {
		Identifier id1 = new Identifier("question");
		
		expected.add(new DuplicateQuestionError(id1));
		expected.add(new DuplicateQuestionError(id1));
		assertEquals(expected, errors);
	}
}
