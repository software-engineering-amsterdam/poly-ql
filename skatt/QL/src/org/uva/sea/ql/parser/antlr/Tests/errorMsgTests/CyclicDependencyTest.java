package org.uva.sea.ql.parser.antlr.Tests.errorMsgTests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.Messages.CyclicDependencyError;
import org.uva.sea.ql.parser.antlr.QL4.Messages.UndefinedQuestionError;

/**
 * Tests the cyclic dependency error messaging
 * @author Sammie Katt
 *
 */
public class CyclicDependencyTest extends QL4ErrorTest {
	
	@BeforeClass
	public static void init() {
		setFile("test/cyclicDependencyTest");
	}
	
	@Test
	public void testCyclicDependency() {
		Identifier id1 = new Identifier("q1");
		Identifier id2 = new Identifier("q2");
		
		expected.add(new UndefinedQuestionError(id1));
		expected.add(new CyclicDependencyError(id1, id2));
		assertEquals(expected, errors);
	}
}
