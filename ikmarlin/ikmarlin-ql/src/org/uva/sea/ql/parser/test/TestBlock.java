package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.Stmt;

public class TestBlock {

	private IParser<Stmt> parser;

	public TestBlock() {
		this.parser = new BlockParser();
	}
	
	@Test
	public void testBlock() throws ParseError {
		assertEquals(parser.parse("x: \"y\" z").getClass(), Block.class);
		assertEquals(parser.parse("x: \"y\" z a: \"b\" c").getClass(), Block.class);
		assertEquals(parser.parse("x: \"y\" z a: \"b\" boolean ( d && e )").getClass(), Block.class);
		assertEquals(parser.parse("a: \"b\" integer ( d + e )").getClass(), Block.class);
		assertEquals(parser.parse("a: \"b\" integer ( d + e ) p: \"q\" integer ( s + t )").getClass(), Block.class);
		assertEquals(parser.parse("a: \"b\" boolean ( d || e ) x: \"y\" z").getClass(), Block.class);
	}

}
