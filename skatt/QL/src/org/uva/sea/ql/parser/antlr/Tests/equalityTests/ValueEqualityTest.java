package org.uva.sea.ql.parser.antlr.Tests.equalityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;

public class ValueEqualityTest	{

	@Test
	public void testNumber() {
		Number num = new Number("1");
		Number numDiff = new Number("2");
		Number numSame = new Number("1");
		
		assertEquals(num, numSame);
		assertFalse(num.equals(numDiff));
	}

	@Test
	public void testBool() {
		Bool num = new Bool("true");
		Bool numDiff = new Bool("false");
		Bool numSame = new Bool("true");
		
		assertEquals(num, numSame);
		assertFalse(num.equals(numDiff));
	}
	
	@Test
	public void testText() {
		Text num = new Text("1");
		Text numDiff = new Text("2");
		Text numSame = new Text("1");
		
		assertEquals(num, numSame);
		assertFalse(num.equals(numDiff));
	}
	
	@Test
	public void testDecimal() {
		Decimal num = new Decimal("1");
		Decimal numDiff = new Decimal("2");
		Decimal numSame = new Decimal("1");
		
		assertEquals(num, numSame);
		assertFalse(num.equals(numDiff));
	}
}
