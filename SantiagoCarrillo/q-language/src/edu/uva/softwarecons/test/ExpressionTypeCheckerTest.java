package edu.uva.softwarecons.test;

import edu.uva.softwarecons.checker.ExpressionTypeChecker;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.expression.literal.BoolExpression;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.expression.literal.IntExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.type.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/13/14
 */

public class ExpressionTypeCheckerTest {

    @Test
    public void andExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new AndExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void orExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new OrExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void notExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new NotExpression(new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void equalExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new EqualExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void notEqualExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new NotEqualExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void greaterExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new GreaterExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void greaterEqualExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new GreaterEqualExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void lessExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new LessExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void lessEqualExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new LessEqualExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void addExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new AddExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void subExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new SubExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void mulExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new MulExpression(new BoolExpression(false), new IntExpression(0)),
                new BooleanType(), null));
    }

    @Test
    public void divExpressionInvalidTypeErrorTest(){
        assertTrue(expressionContainsTypeError(new DivExpression(new BoolExpression(false), new BoolExpression(false)),
                new BooleanType(), null));
    }

    @Test
    public void IdExpressionInvalidTypesErrorTest(){
        assertTrue(hasIdExpressionInvalidBooleanType(new DateType()));
        assertTrue(hasIdExpressionInvalidBooleanType(new DecimalType()));
        assertTrue(hasIdExpressionInvalidBooleanType(new IntegerType()));
        assertTrue(hasIdExpressionInvalidBooleanType(new MoneyType()));
        assertTrue(hasIdExpressionInvalidBooleanType(new StringType()));
    }

    @Test
    public void IdExpressionValidTypeErrorTest(){
        assertTrue(!hasIdExpressionInvalidBooleanType(new BooleanType()));
    }

    private boolean hasIdExpressionInvalidBooleanType(Type type) {
        Map<String, Type> types = new HashMap<String, Type>();
        String conditionId = "testQuestion";
        types.put(conditionId, type);
        IdExpression idExpression = new IdExpression(conditionId);
        return expressionContainsTypeError(idExpression, new BooleanType(), types);
    }

    private boolean expressionContainsTypeError(Expression expression, Type expectedType, Map<String, Type> types){
        ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker(types);
        expressionTypeChecker.validateType("", expression, expectedType);
        return !expressionTypeChecker.getErrors().isEmpty();
    }



}
