package org.uva.sea.ql.parser.antlr.Tests.EvaluationTests;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;

/**
 * Abstract parent class of all evaluation tests
 * @author Sammie Katt
 */
public abstract class QL4EvaluationTest {

	public Map<Identifier, Question> questions;
	
	@Before 
	public void setUp() {
		Map<Identifier, Question> questions = new HashMap<Identifier, Question>();
	}
}
