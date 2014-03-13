package org.uva.sea.ql.typechecker;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.BooleanLiteral;
import org.uva.sea.ql.ast.literal.IntegerLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.operators.arithmetic.Add;
import org.uva.sea.ql.ast.operators.comparison.GT;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Questions;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.type.BooleanType;

import problems.CompatibleError;
import problems.DuplicateLabelWarning;
import problems.Error;
import problems.NotDeclaredError;
import problems.RedeclaredWarning;
import problems.TypeError;
import problems.Warning;

public class TestTypeChecker extends AbstractTestTypeChecker{

	
	@Test
	public void testDuplicateLabel(){
		Question q1 = new Question(new Identifier("id1"), new StringLiteral("vraag"), new BooleanType());
		Question q2 = new Question(new Identifier("id2"), new StringLiteral("vraag"), new BooleanType());
		List<Statement> questions = new ArrayList<Statement>();
		questions.add(q1);
		questions.add(q2);

		for(Statement q : questions){
			q.accept(stat);
		}
		
		Warning expectedWarning = new DuplicateLabelWarning(new StringLiteral("vraag"));
		assertTrue(problems.getWarnings().contains(expectedWarning));
	}
	
	@Test 
	public void testRedeclared(){
		Question q1 = new Question(new Identifier("id1"), new StringLiteral("vraag"), new BooleanType());
		Question q2 = new Question(new Identifier("id1"), new StringLiteral("vraag"), new BooleanType());
		List<Statement> questions = new ArrayList<Statement>();
		questions.add(q1);
		questions.add(q2);

		for(Statement q : questions){
			q.accept(stat);
		}
		
		Warning expectedWarning = new RedeclaredWarning(new Identifier("id1"), new BooleanType());
		assertTrue(problems.getWarnings().contains(expectedWarning));
	}
	
	@Test
	public void testCompatible(){
		Expression left = new BooleanLiteral(true);
		Expression right = new IntegerLiteral(1);
		Add add = new Add(left,right);
		ExpressionChecker.checkExpression(env, problems, add);
		
		Error expectedError = new TypeError(left,add.typeOf(env));

		assertTrue(problems.getErrors().contains(expectedError));
	}
	
	public void testComparible(){
		Expression left = new BooleanLiteral(true);
		Expression right = new IntegerLiteral(1);
		GT gt = new GT(left,right); //true>1 
		ExpressionChecker.checkExpression(env, problems, gt);
		
		Error expectedError = new CompatibleError(left,right);
		assertTrue(problems.getErrors().contains(expectedError));
	}
	
	@Test
	public void testNotDeclared(){
		Expression left = new Identifier("id");
		Question q1 = new Question(new Identifier("id1"), new StringLiteral("vraag"), new BooleanType());
		Questions qs = new Questions(q1);
		IfStatement con = new IfStatement(left, qs);
		
		con.accept(stat);
		Error expectedError = new NotDeclaredError(left);
		assertTrue(problems.getErrors().contains(expectedError));
		
	}
}
