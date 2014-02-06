package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.parser.jacc.Parser;

public class TestExpressions {
	
	public Parser parser;
	
	public TestExpressions(){
		this.parser = new Parser();
	}
	
	@Test
	public void TestArithmetic(){
		
		assertEquals(parser.parser("a + b").getClass(), Add.class);
		assertEquals(parser.parser("a - b").getClass(), Sub.class);
	}
}
