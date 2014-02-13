package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.Question;

public class TestTypes extends TestParser{

	@Test
	public void testTypes(){
	
		assertEquals(parser.parser("var : \"label\" integer").getClass(), Question.class);
		assertEquals(parser.parser("var : \"label\" string").getClass(), Question.class);
		assertEquals(parser.parser("var : \"label\" money").getClass(), Question.class);
		assertEquals(parser.parser("var : \"label\" boolean").getClass(), Question.class);
	}
}
