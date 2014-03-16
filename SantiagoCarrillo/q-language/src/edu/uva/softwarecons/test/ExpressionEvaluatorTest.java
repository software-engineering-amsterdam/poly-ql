package edu.uva.softwarecons.test;

import edu.uva.softwarecons.evaluator.ExpressionEvaluator;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.EqualExpression;
import edu.uva.softwarecons.model.expression.comparison.NotEqualExpression;
import edu.uva.softwarecons.model.expression.literal.BoolExpression;
import edu.uva.softwarecons.model.expression.literal.IntExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.value.Value;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class ExpressionEvaluatorTest {

    final ExpressionEvaluator expressionEvaluator =  new ExpressionEvaluator();

    @Test
    public void evaluateArithmeticAddExpressionTest() {
        AddExpression addExpression = new AddExpression(new IntExpression(2), new IntExpression(3));
        Value value = expressionEvaluator.visitAddExpression(addExpression);
        assertTrue(Integer.parseInt(value.getValue()) == 5);
    }

    @Test
    public void evaluateArithmeticSubExpressionTest() {
        SubExpression subExpression = new SubExpression(new IntExpression(5), new IntExpression(3));
        Value value = expressionEvaluator.visitSubExpression(subExpression);
        assertTrue(Integer.parseInt(value.getValue()) == 2);
    }

    @Test
    public void evaluateArithmeticMulExpressionTest() {
        MulExpression mulExpression = new MulExpression(new IntExpression(5), new IntExpression(3));
        Value value = expressionEvaluator.visitMulExpression(mulExpression);
        assertTrue(Integer.parseInt(value.getValue()) == 15);
    }

    @Test
    public void evaluateArithmeticDivExpressionTest() {
        DivExpression divExpression = new DivExpression(new IntExpression(10), new IntExpression(2));
        Value value = expressionEvaluator.visitDivExpression(divExpression);
        assertTrue(Integer.parseInt(value.getValue()) == 5);
    }

    @Test
    public void evaluateAndExpressionTest() {
        AndExpression andExpression = new AndExpression(new BoolExpression(true), new BoolExpression(false));
        assertFalse(Boolean.valueOf(expressionEvaluator.visitAndExpression(andExpression).getValue()));
    }

    @Test
    public void evaluateOrExpressionTest() {
        OrExpression orExpression = new OrExpression(new BoolExpression(true), new BoolExpression(false));
        assertTrue(Boolean.valueOf(expressionEvaluator.visitOrExpression(orExpression).getValue()));
    }

    @Test
    public void evaluateNotExpressionTest() {
        NotExpression notExpression = new NotExpression(new BoolExpression(true));
        assertFalse(Boolean.valueOf(expressionEvaluator.visitNotExpression(notExpression).getValue()));
    }

    @Test
    public void evaluateNotEqualBooleanExpressionTest() {
        NotEqualExpression notEqualExpression = new NotEqualExpression(new BoolExpression(false), new BoolExpression(true));
        assertTrue(Boolean.valueOf(expressionEvaluator.visitNotEqualExpression(notEqualExpression).getValue()));
    }

    @Test
    public void evaluateEqualBooleanExpressionTest() {
        EqualExpression equalExpression = new EqualExpression(new BoolExpression(true), new BoolExpression(true));
        assertTrue(Boolean.valueOf(expressionEvaluator.visitEqualExpression(equalExpression).getValue()));
    }

    @Test
    public void evaluateEqualNumericExpressionTest() {
        EqualExpression equalExpression = new EqualExpression(new IntExpression(1), new IntExpression(1));
        assertTrue(Boolean.valueOf(expressionEvaluator.visitEqualExpression(equalExpression).getValue()));
    }

    @Test
    public void evaluateNotEqualNumericExpressionTest() {
        NotEqualExpression notEqualExpression = new NotEqualExpression(new IntExpression(2), new IntExpression(1));
        assertTrue(Boolean.valueOf(expressionEvaluator.visitNotEqualExpression(notEqualExpression).getValue()));
    }

    @Test
    public void evaluateEqualDateExpressionTest() {
        EqualExpression equalExpression = new EqualExpression(new IntExpression(1), new IntExpression(1));
        assertTrue(Boolean.valueOf(expressionEvaluator.visitEqualExpression(equalExpression).getValue()));
    }

    @Test
    public void evaluateNotEqualDateExpressionTest() {
        NotEqualExpression notEqualExpression = new NotEqualExpression(new IntExpression(2), new IntExpression(1));
        assertTrue(Boolean.valueOf(expressionEvaluator.visitNotEqualExpression(notEqualExpression).getValue()));
    }


    @Test
    public void evaluateGreaterNumericExpressionTest() {
        NotEqualExpression notEqualExpression = new NotEqualExpression(new IntExpression(2), new IntExpression(1));
        assertTrue(Boolean.valueOf(expressionEvaluator.visitNotEqualExpression(notEqualExpression).getValue()));
    }
}
