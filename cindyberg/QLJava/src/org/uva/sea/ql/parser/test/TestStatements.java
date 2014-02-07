package org.uva.sea.ql.parser.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.*;

public class TestStatements extends TestParser{

		@Test
		public void TestQuestion(){
		
			assertEquals(parser.parser("var : \"label\" boolean").getClass(), Question.class);
			assertEquals(parser.parser("var : \"label\" boolean ( expr ) ").getClass(), ExprQuestion.class);
		}
		
}
