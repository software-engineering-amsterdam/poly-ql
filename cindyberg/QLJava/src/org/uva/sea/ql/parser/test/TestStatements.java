package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.ExpressionQuestion;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.parser.jacc.ParseException;

public class TestStatements extends TestParser{

		@Test
		public void testQuestion() throws ParseException{
		
			assertEquals(parser.parser("var : \"label\" boolean").getClass(), Question.class);
			assertEquals(parser.parser("var : \"label\" boolean ( true ) ").getClass(), ExpressionQuestion.class);
			assertEquals(parser.parser("var : \"label\" string (bla) ").getClass(), ExpressionQuestion.class);
			//assertEquals(parser.parser("var : \"label\" string (hallo lange tekst)").getClass(), ExpressionQuestion.class);
			
		}
		
		@Test
		public void testConditional() throws ParseException{
			
			assertEquals(parser.parser("if ( hashouse ) {"
					+ "var : \"label\" boolean}").getClass(), IfStatement.class);
			assertEquals(parser.parser("if ( hashouse ) {"
					+ "var : \"label\" boolean ( expr ) }").getClass(), IfStatement.class);
			assertEquals(parser.parser("if ( hashouse ) {"
					+ "var : \"label\" boolean }"
					+ "else { var3 : \"label\" boolean } ").getClass(), IfElseStatement.class);
			assertEquals(parser.parser("if ( hashouse ) {"
					+ "var : \"label\" boolean }"
					+ "else { var3 : \"label\" boolean ( expr ) } ").getClass(), IfElseStatement.class);
		}
		
		
}
