package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.comparison.*;
import org.uva.sea.ql.ast.operators.logical.*;

public class TestExpressions extends TestParser{
	
	@Test
	public void testArithmetic(){
		
		assertEquals(parser.parser("a + b").getClass(), Add.class);
		assertEquals(parser.parser("a + b + c").getClass(), Add.class);
		assertEquals(parser.parser("a - b").getClass(), Sub.class);
		assertEquals(parser.parser("a - b - c").getClass(), Sub.class);
		assertEquals(parser.parser(" a * b").getClass(), Mul.class);
		assertEquals(parser.parser("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parser("a / b").getClass(), Div.class);
		assertEquals(parser.parser("a / b / c").getClass(), Div.class);
		assertEquals(parser.parser("-a").getClass(), Neg.class);	
		
		//special cases
		assertEquals(parser.parser("a + b * c").getClass(), Add.class);
		assertEquals(parser.parser("a * b + c").getClass(), Add.class);
		assertEquals(parser.parser("a * b //+ c ").getClass(), Mul.class);
		assertEquals(parser.parser(" a + b / c").getClass(), Add.class);
		assertEquals(parser.parser(" a / b + c").getClass(), Add.class);
		assertEquals(parser.parser(" (a + b) / c").getClass(), Div.class);
		assertEquals(parser.parser(" a / (b + c)").getClass(), Div.class);
		assertEquals(parser.parser("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parser("a * (b + c)").getClass(), Mul.class);
		assertEquals(parser.parser("-(a + b)").getClass(), Neg.class);
		
	}
	
	@Test
	public void testLogical(){
		
		assertEquals(parser.parser("a && b").getClass(), And.class);
		assertEquals(parser.parser("a && b && c").getClass(), And.class);
		assertEquals(parser.parser("a || b").getClass(), Or.class);
		assertEquals(parser.parser(" a || b || c").getClass(), Or.class);
		assertEquals(parser.parser("!a").getClass(), Not.class);	
		
		assertEquals(parser.parser("a && b || c").getClass(), And.class);
		assertEquals(parser.parser("!(a && b)").getClass(), Not.class);
		assertEquals(parser.parser("a || (b && c)").getClass(), Or.class);
	}
	
	@Test
	public void testComparison(){
		
		assertEquals(parser.parser("a == a").getClass(), Eq.class);
		assertEquals(parser.parser("a != c").getClass(), NEq.class);
		assertEquals(parser.parser("a >= b").getClass(), GEq.class);
		assertEquals(parser.parser("a > b").getClass(), GT.class);
		assertEquals(parser.parser("a <= b").getClass(), LEq.class);
		assertEquals(parser.parser("a < b").getClass(), LT.class);
	}

}
