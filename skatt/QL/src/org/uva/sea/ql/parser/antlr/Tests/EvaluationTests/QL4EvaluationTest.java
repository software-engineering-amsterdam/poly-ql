package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import org.junit.Before;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.EvaluatorVisitor;

/**
 * Abstract parent class of all evaluation tests
 * @author Sammie Katt
 */
public abstract class QL4EvaluationTest {

	public EvaluatorVisitor visitor;
	
	@Before 
	public void setUp() {
		visitor = new EvaluatorVisitor();
	}
}
