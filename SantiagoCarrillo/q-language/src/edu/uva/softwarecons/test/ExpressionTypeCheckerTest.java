package edu.uva.softwarecons.test;

import edu.uva.softwarecons.checker.ExpressionTypeChecker;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.comparison.EqualExpression;
import edu.uva.softwarecons.model.expression.comparison.GreaterEqualExpression;
import edu.uva.softwarecons.model.expression.comparison.GreaterExpression;
import edu.uva.softwarecons.model.expression.comparison.LessEqualExpression;
import edu.uva.softwarecons.model.expression.comparison.LessExpression;
import edu.uva.softwarecons.model.expression.comparison.NotEqualExpression;
import edu.uva.softwarecons.model.expression.literal.BoolExpression;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.expression.literal.IntExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.DateType;
import edu.uva.softwarecons.model.type.DecimalType;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.type.MoneyType;
import edu.uva.softwarecons.model.type.StringType;
import edu.uva.softwarecons.model.type.Type;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Falconlabs
 * @author Santiago Carrillo
 * Date: 2/13/14
 */

public class ExpressionTypeCheckerTest
{

    @Test
    public void andExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new AndExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null ) );
    }

    @Test
    public void orExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new OrExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null ) );
    }

    @Test
    public void notExpressionInvalidTypeErrorTest()
    {
        assertTrue( expressionContainsTypeError( new NotExpression( new IntExpression( 0 ) ), null ) );
    }

    @Test
    public void equalExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new EqualExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null ) );
    }

    @Test
    public void notEqualExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new NotEqualExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null ) );
    }

    @Test
    public void greaterExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new GreaterExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null ) );
    }

    @Test
    public void greaterEqualExpressionInvalidTypeErrorTest()
    {
        assertTrue( expressionContainsTypeError(
            new GreaterEqualExpression( new BoolExpression( false ), new IntExpression( 0 ) ), null ) );
    }

    @Test
    public void lessExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new LessExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null ) );
    }

    @Test
    public void lessEqualExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new LessEqualExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null ) );
    }

    @Test
    public void addExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new AddExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null ) );
    }

    @Test
    public void subExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new SubExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null ) );
    }

    @Test
    public void mulExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new MulExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null ) );
    }

    @Test
    public void divExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new DivExpression( new BoolExpression( false ), new BoolExpression( false ) ),
                                         null ) );
    }

    @Test
    public void IdExpressionInvalidTypesErrorTest()
    {
        assertTrue( hasIdExpressionInvalidBooleanType( new DateType() ) );
        assertTrue( hasIdExpressionInvalidBooleanType( new DecimalType() ) );
        assertTrue( hasIdExpressionInvalidBooleanType( new IntegerType() ) );
        assertTrue( hasIdExpressionInvalidBooleanType( new MoneyType() ) );
        assertTrue( hasIdExpressionInvalidBooleanType( new StringType() ) );
    }

    @Test
    public void IdExpressionValidTypeErrorTest()
    {
        assertTrue( !hasIdExpressionInvalidBooleanType( new BooleanType() ) );
    }

    private boolean hasIdExpressionInvalidBooleanType( Type type )
    {
        Map<String, Type> types = new HashMap<String, Type>();
        String conditionId = "testQuestion";
        types.put( conditionId, type );
        IdExpression idExpression = new IdExpression( conditionId );
        return expressionContainsTypeError( idExpression, types );
    }

    private boolean expressionContainsTypeError( Expression expression, Map<String, Type> types )
    {
        ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker( types );
        expressionTypeChecker.validateType( "", expression );
        return !expressionTypeChecker.getErrors().isEmpty();
    }


}