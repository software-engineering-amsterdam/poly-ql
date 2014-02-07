package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.booleans.*;
import org.uva.sea.ql.ast.operators.comparison.*;

public class TestExpressions extends TestParser{
	
	@Test
	public void TestArithmetic(){
		
		assertEquals(parser.parser("a + b").getClass(), Add.class);
		assertEquals(parser.parser("a - b").getClass(), Sub.class);
		assertEquals(parser.parser(" a * b").getClass(), Mul.class);
		assertEquals(parser.parser("a / b").getClass(), Div.class);
		assertEquals(parser.parser("-a").getClass(), Neg.class);	
	}
	
	@Test
	public void TestBooleans(){
		
		assertEquals(parser.parser("a && b").getClass(), And.class);
		assertEquals(parser.parser("a || b").getClass(), Or.class);
		assertEquals(parser.parser("!a").getClass(), Not.class);	
	}
	
	@Test
	public void TestComparison(){
		
		//assertEquals(parser.parser("a == b").getClass(), Eq.class);
		//assertEquals(parser.parser("a != b").getClass(), NEq.class);
		assertEquals(parser.parser("a >= b").getClass(), GEq.class);
		assertEquals(parser.parser("a > b").getClass(), GT.class);
		assertEquals(parser.parser("a <= b").getClass(), LEq.class);
		assertEquals(parser.parser("a < b").getClass(), LT.class);
	}

}
