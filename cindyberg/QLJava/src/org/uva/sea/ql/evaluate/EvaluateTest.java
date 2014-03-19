package org.uva.sea.ql.evaluate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.parser.jacc.ParseException;
import org.uva.sea.ql.parser.jacc.Parser;

public class EvaluateTest {

	private Parser parser = new Parser();
	private EvaluateExpression eval = new EvaluateExpression(new VariableEnvironment());
	
	@Test
	public void evaluateArithmetic() throws ParseException{
		
		assertEquals(evalResult("1+2").getValue(),new IntegerValue(3).getValue());
		assertEquals(evalResult("5*4").getValue(),new IntegerValue(20).getValue());
		assertEquals(evalResult("1+2*5").getValue(),new IntegerValue(11).getValue());
		assertEquals(evalResult("(1+2)*5").getValue(),new IntegerValue(15).getValue());
		assertEquals(evalResult("2/2").getValue(),new IntegerValue(1).getValue());
		assertEquals(evalResult("5-2").getValue(),new IntegerValue(3).getValue());
		assertEquals(evalResult("5--2").getValue(),new IntegerValue(7).getValue());

	}
	
	@Test
	public void evaluateLogical() throws ParseException{
		assertEquals(evalResult("true&&true").getValue(),new BooleanValue(true).getValue());
		assertEquals(evalResult("true&&false").getValue(),new BooleanValue(false).getValue());
		assertEquals(evalResult("true||false").getValue(),new BooleanValue(true).getValue());
		assertEquals(evalResult("!false").getValue(),new BooleanValue(true).getValue());
	}
	
	@Test
	public void evaluateComparison() throws ParseException{
		assertEquals(evalResult("5 > 2").getValue(),new BooleanValue(true).getValue());
		assertEquals(evalResult("5==5").getValue(),new BooleanValue(true).getValue());
		assertEquals(evalResult("4!=2").getValue(),new BooleanValue(true).getValue());
		assertEquals(evalResult("6 < 3").getValue(),new BooleanValue(false).getValue());
		assertEquals(evalResult("6 >= 3").getValue(),new BooleanValue(true).getValue());
	}
	
	/*@Test
	public void evaluateString() throws ParseException{
		assertEquals(evalResult("bla").getValue(),new StringValue("bla").getValue());
	}*/
	
	private Value evalResult(String expression) throws ParseException{
		Expression exp = (Expression) parser.parser(expression);
		return exp.accept(eval);
	}
}
