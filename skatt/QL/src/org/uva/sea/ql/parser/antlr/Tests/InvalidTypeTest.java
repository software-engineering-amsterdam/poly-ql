package org.uva.sea.ql.parser.antlr.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests on the invalidtype error managing
 * @author Sammie
 *
 */
public class InvalidTypeTest extends QL4Test {

	@Before 
	public void setUp() {
		fileToParse = "test/invalidTypeTest";
	}
	
	@Test
	public void testInvalidTypeTest() {
		//expected.add(new InvalidTypeError(expr, type))
		
		assertEquals(expected, errors);
	}
}
