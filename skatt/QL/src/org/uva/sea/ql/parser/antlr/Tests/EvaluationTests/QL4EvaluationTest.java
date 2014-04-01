package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.EvaluatorVisitor;

/**
 * Abstract parent class of all evaluation tests
 * @author Sammie Katt
 */
public abstract class QL4EvaluationTest {

	public EvaluatorVisitor visitor;
	public Map<Identifier, Question> env = new HashMap<Identifier, Question>();
	
	@Before 
	public void setUp() {
		visitor = new EvaluatorVisitor(env);
	}
}
