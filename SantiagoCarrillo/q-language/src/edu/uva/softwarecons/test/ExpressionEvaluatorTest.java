package edu.uva.softwarecons.test;

import edu.uva.softwarecons.evaluator.ExpressionEvaluator;
import edu.uva.softwarecons.exception.CompareException;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.literal.IntExpression;
import edu.uva.softwarecons.model.value.Value;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class ExpressionEvaluatorTest {

    @Test
    public void evaluateArithmeticAddExpressionTest() {
        try {
            AddExpression addExpression = new AddExpression(new IntExpression(2), new IntExpression(3));
            ExpressionEvaluator expressionEvaluator =  new ExpressionEvaluator(null);
            Value value = expressionEvaluator.visitAddExpression(addExpression);
            assertTrue(Integer.parseInt(value.getValue()) == 5);
        } catch (CompareException e) {}
    }

    @Test
    public void evaluateArithmeticSubExpressionTest() {
        try {
            SubExpression subExpression = new SubExpression(new IntExpression(5), new IntExpression(3));
            ExpressionEvaluator expressionEvaluator =  new ExpressionEvaluator(null);
            Value value = expressionEvaluator.visitSubExpression(subExpression);
            assertTrue(Integer.parseInt(value.getValue()) == 2);
        } catch (CompareException e) {}
    }

    @Test
    public void evaluateArithmeticMulExpressionTest() {
        try {
            MulExpression mulExpression = new MulExpression(new IntExpression(5), new IntExpression(3));
            ExpressionEvaluator expressionEvaluator =  new ExpressionEvaluator(null);
            Value value = expressionEvaluator.visitMulExpression(mulExpression);
            assertTrue(Integer.parseInt(value.getValue()) == 15);
        } catch (CompareException e) {}
    }

    @Test
    public void evaluateArithmeticDivExpressionTest() {
        try {
            DivExpression divExpression = new DivExpression(new IntExpression(10), new IntExpression(2));
            ExpressionEvaluator expressionEvaluator =  new ExpressionEvaluator(null);
            Value value = expressionEvaluator.visitDivExpression(divExpression);
            assertTrue(Integer.parseInt(value.getValue()) == 5);
        } catch (CompareException e) {}
    }

    @Test
    public void evaluateArithmeticDivZeroExpressionTest() {
        try {
            DivExpression divExpression = new DivExpression(new IntExpression(1), new IntExpression(0));
            ExpressionEvaluator expressionEvaluator =  new ExpressionEvaluator(null);
            expressionEvaluator.visitDivExpression(divExpression);
            assertTrue(false);
        } catch (CompareException e) {
            assertTrue(true);
        }
    }
}
