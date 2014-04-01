package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.EvaluatorVisitor;

public class EvaluateIdentifierTest extends QL4EvaluationTest {

	@Override
	@Before
	public void setUp() {
		Identifier id = new Identifier("Question");
		Number num = new Number("2");
		
		env.put(id, num);
		visitor = new EvaluatorVisitor(env);
	}
	
	@Test
	public void testIdentifier() {
		Identifier id = new Identifier("Question");
		
		assertEquals(visitor.visit(id), new Number("2"));
		assertFalse(visitor.visit(id).equals(new Number("1")));
	}
}
