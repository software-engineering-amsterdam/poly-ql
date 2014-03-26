package org.uva.sea.ql.parser.antlr.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.Messages.DuplicateLabelError;

/**
 * Tests the duplicate label handeling
 * @author Sammie Katt
 */
public class DuplicateLabelTest extends QL4Test {

	@BeforeClass
	public static void init() {
		setFile("test/doubleLabelTest");
	}
	
	@Test
	public void testDuplicateLabel() {
		Label qlabel1 = new Label("This is an question label");
		Label qlabel2 = new Label("This is a question label");
		
		expected.add(new DuplicateLabelError(qlabel1));
		expected.add(new DuplicateLabelError(qlabel2));
		assertEquals(expected, errors);
	}
}
