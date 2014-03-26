package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import expr.operation.Add;
import expr.operation.Div;
import expr.relational.GT;
import expr.relational.LEq;
import expr.relational.LT;

public class ExprTest1  {

	QParse parser = new QParse();
	
	@Test 
	public void testQParse() throws ParseError, IOException {
		
//		String test = "C:\\Users\\nisha\\Documents\\poly-ql\\Nisha\\QLJava\\src\\test1.ql";
//		Form file = parseF(test);
		


	}
	
	@Test
	public void testAdd() throws ParseError, IOException {
		assertEquals(Add.class, parser.parseE("a + b").getClass());
		assertEquals(Add.class, parser.parseE("a + b + c").getClass());
		assertEquals(Add.class, parser.parseE("(a + b + c)").getClass());
		assertEquals(Add.class, parser.parseE("a + (b + c)").getClass());
		assertEquals(Add.class, parser.parseE("(a + b) + c").getClass());
		assertEquals(Add.class, parser.parseE("a + b * c").getClass());
		assertEquals(Add.class, parser.parseE("a * b + c").getClass());
		}
	@Test
	public void testDiv() throws ParseError, IOException {
		assertEquals(Div.class, parser.parseE("a / b").getClass());
		assertEquals(Div.class, parser.parseE("a * b / c").getClass());
		assertEquals(Div.class, parser.parseE("a / (b * c)").getClass());
		assertEquals(Div.class, parser.parseE("(a * b) / c").getClass());
		assertEquals(Div.class, parser.parseE("(a / b)").getClass());
		assertEquals(Div.class, parser.parseE("(a + b) / c").getClass());
		assertEquals(Div.class, parser.parseE("a / (b + c)").getClass());
	}
	
	@Test
	public void testRels() throws ParseError, IOException {
		assertEquals(LT.class, parser.parseE("a < b").getClass());
		assertEquals(LT.class, parser.parseE("a < b + c").getClass());
		assertEquals(LT.class, parser.parseE("a < (b * c)").getClass());
		assertEquals(LT.class, parser.parseE("(a * b) < c").getClass());
		assertEquals(LEq.class, parser.parseE("(a <= b)").getClass());
		assertEquals(GT.class, parser.parseE("a + b > c").getClass());
	}

	
	
	
}
