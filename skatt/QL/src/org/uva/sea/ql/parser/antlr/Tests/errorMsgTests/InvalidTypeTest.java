package org.uva.sea.ql.parser.antlr.Tests.errorMsgTests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.OrExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.Messages.InvalidTypeError;


/**
 * Tests on the invalidtype error managing
 * @author Sammie
 *
 */
public class InvalidTypeTest extends QL4ErrorTest {

	@BeforeClass
	public static void init() {
		fileToParse = "test/invalidTypeTest";
	}
	
	@Test
	public void testInvalidTypeTest() {
		// create literals
		Number one1 = new Number("1");
		Number one2 = new Number("1");
		
		Bool falseBool = new Bool("false");
		
		// create Expressions
		OrExpr or1 = new OrExpr(one1, one2);
		OrExpr or2 = new OrExpr(one1, falseBool);
		
		// add errors		
		expected.add(new InvalidTypeError(or1));
		expected.add(new InvalidTypeError(or2));
		
		//compare
		assertEquals(expected, errors);
	}
}
