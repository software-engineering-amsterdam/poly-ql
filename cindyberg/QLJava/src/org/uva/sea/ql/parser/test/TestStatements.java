package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.uva.sea.ql.ast.statement.*;

public class TestStatements extends TestParser{

		@Test
		public void testQuestion(){
		
			assertEquals(parser.parser("var : \"label\" boolean").getClass(), Question.class);
			assertEquals(parser.parser("var : \"label\" boolean ( expr ) ").getClass(), ExprQuestion.class);
			//werkt niet :( 
			assertEquals(parser.parser("var : \"label\" boolean\n"
					+ "var2 : \"label2\" boolean ( expr2 ) ").getClass(), QuestionSet.class);
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
