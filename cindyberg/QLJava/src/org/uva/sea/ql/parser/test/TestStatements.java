package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.ExprQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.IfElse;
import org.uva.sea.ql.ast.statement.Question;

public class TestStatements extends TestParser{

		@Test
		public void testQuestion(){
		
			assertEquals(parser.parser("var : \"label\" boolean").getClass(), Question.class);
			assertEquals(parser.parser("var : \"label\" boolean ( expr ) ").getClass(), ExprQuestion.class);
			
		}
		
		@Test
		public void testConditional(){
			
			assertEquals(parser.parser("if ( hashouse ) {"
					+ "var : \"label\" boolean}").getClass(), If.class);
			assertEquals(parser.parser("if ( hashouse ) {"
					+ "var : \"label\" boolean ( expr ) }").getClass(), If.class);
			assertEquals(parser.parser("if ( hashouse ) {"
					+ "var : \"label\" boolean }"
					+ "else { var3 : \"label\" boolean } ").getClass(), IfElse.class);
			assertEquals(parser.parser("if ( hashouse ) {"
					+ "var : \"label\" boolean }"
					+ "else { var3 : \"label\" boolean ( expr ) } ").getClass(), IfElse.class);
		}
		
		
}
