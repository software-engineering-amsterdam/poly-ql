package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;
import org.uva.sea.ql.ast.stmt.Stmt;

public class TestStatements {

	private IParser<Stmt> parser;

	public TestStatements() {
		this.parser = new StmtParser();
	}
	
	@Test
	public void testAnswerable() throws ParseError {
		assertEquals(parser.parse("a: \"b\" c").getClass(), AnswerableQuestion.class);
	}

	@Test
	public void testComputed() throws ParseError {
		assertEquals(parser.parse("a: \"b\" c ( x + y )").getClass(), ComputedQuestion.class);
		assertEquals(parser.parse("a: \"b\" c ( ( x + y ) * z )").getClass(), ComputedQuestion.class);
		assertEquals(parser.parse("a: \"b\" c ( x )").getClass(), ComputedQuestion.class);
		assertEquals(parser.parse("a: \"b\" c ( 1 )").getClass(), ComputedQuestion.class);
		assertEquals(parser.parse("a: \"b\" c ( true )").getClass(), ComputedQuestion.class);
		assertEquals(parser.parse("a: \"b\" c ( false )").getClass(), ComputedQuestion.class);
		assertEquals(parser.parse("a: \"b\" c ( \"x\" )").getClass(), ComputedQuestion.class);
	}
	
	@Test
	public void testIfThen() throws ParseError {
		assertEquals(parser.parse("if ( x + y ) { b }").getClass(), IfThenStatement.class);
		assertEquals(parser.parse("if ( ( x + y ) * z  ) { b }").getClass(), IfThenStatement.class);
		assertEquals(parser.parse("if ( x ) { b }").getClass(), IfThenStatement.class);
		assertEquals(parser.parse("if ( 1 ) { b }").getClass(), IfThenStatement.class);
		assertEquals(parser.parse("if ( true ) { b }").getClass(), IfThenStatement.class);
		assertEquals(parser.parse("if ( false ) { b }").getClass(), IfThenStatement.class);
		assertEquals(parser.parse("if ( \"x\" ) { b }").getClass(), IfThenStatement.class);
	}
	
	@Test
	public void testIfThenElse() throws ParseError {
		assertEquals(parser.parse("if ( x + y ) { b } else { e }").getClass(), IfThenElseStatement.class);
		assertEquals(parser.parse("if ( ( x + y ) * z  ) { b } else { e }").getClass(), IfThenElseStatement.class);
		assertEquals(parser.parse("if ( x ) { b } else { e }").getClass(), IfThenElseStatement.class);
		assertEquals(parser.parse("if ( 1 ) { b } else { e }").getClass(), IfThenElseStatement.class);
		assertEquals(parser.parse("if ( true ) { b } else { e }").getClass(), IfThenElseStatement.class);
		assertEquals(parser.parse("if ( false ) { b } else { e }").getClass(), IfThenElseStatement.class);
		assertEquals(parser.parse("if ( \"x\" ) { b } else { e }").getClass(), IfThenElseStatement.class);
	}

}
