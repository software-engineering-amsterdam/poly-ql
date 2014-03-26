package edu.uva.softwarecons.test;

import edu.uva.softwarecons.checker.ExpressionTypeChecker;
import edu.uva.softwarecons.checker.TypeChecker;
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
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/13/14
 */

public class ExpressionTypeCheckerTest
{

    @Test
    public void andExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new AndExpression( new BoolExpression( false ), new IntExpression( 0 ) ), null,
                                         TypeChecker.getSingleInvalidTypeList( new BooleanType() ) ) );
    }

    @Test
    public void orExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new OrExpression( new BoolExpression( false ), new IntExpression( 0 ) ), null,
                                         TypeChecker.getSingleInvalidTypeList( new BooleanType() ) ) );
    }

    @Test
    public void notExpressionInvalidTypeErrorTest()
    {
        assertTrue( expressionContainsTypeError( new NotExpression( new IntExpression( 0 ) ), null,
                                                 TypeChecker.getSingleInvalidTypeList( new BooleanType() ) ) );
    }

    @Test
    public void equalExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new EqualExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null, null ) );
    }

    @Test
    public void notEqualExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new NotEqualExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null, null ) );
    }

    @Test
    public void greaterExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new GreaterExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null, TypeChecker.getComparableExpressionInvalidTypesList() ) );
    }

    @Test
    public void greaterEqualExpressionInvalidTypeErrorTest()
    {
        assertTrue( expressionContainsTypeError(
            new GreaterEqualExpression( new BoolExpression( false ), new IntExpression( 0 ) ), null,
            TypeChecker.getComparableExpressionInvalidTypesList() ) );
    }

    @Test
    public void lessExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new LessExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null, TypeChecker.getComparableExpressionInvalidTypesList() ) );
    }

    @Test
    public void lessEqualExpressionInvalidTypeErrorTest()
    {

        assertTrue(
            expressionContainsTypeError( new LessEqualExpression( new BoolExpression( false ), new IntExpression( 0 ) ),
                                         null, TypeChecker.getComparableExpressionInvalidTypesList() ) );
    }

    @Test
    public void addExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new AddExpression( new BoolExpression( false ), new IntExpression( 0 ) ), null,
                                         TypeChecker.getSingleInvalidTypeList( new IntegerType() ) ) );
    }

    @Test
    public void subExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new SubExpression( new BoolExpression( false ), new IntExpression( 0 ) ), null,
                                         TypeChecker.getSingleInvalidTypeList( new IntegerType() ) ) );
    }

    @Test
    public void mulExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new MulExpression( new BoolExpression( false ), new IntExpression( 0 ) ), null,
                                         TypeChecker.getSingleInvalidTypeList( new IntegerType() ) ) );
    }

    @Test
    public void divExpressionInvalidTypeErrorTest()
    {
        assertTrue(
            expressionContainsTypeError( new DivExpression( new BoolExpression( false ), new BoolExpression( false ) ),
                                         null, TypeChecker.getSingleInvalidTypeList( new IntegerType() ) ) );
    }

    @Test
    public void IdExpressionInvalidTypesErrorTest()
    {
        assertTrue( areIdTypesValidForBinaryExpression( new DateType(), new BooleanType() ) );
        assertTrue( areIdTypesValidForBinaryExpression( new DecimalType(), new BooleanType() ) );
        assertTrue( areIdTypesValidForBinaryExpression( new IntegerType(), new BooleanType() ) );
        assertTrue( areIdTypesValidForBinaryExpression( new MoneyType(), new BooleanType() ) );
        assertTrue( areIdTypesValidForBinaryExpression( new StringType(), new BooleanType() ) );
    }

    @Test
    public void IdExpressionValidTypeErrorTest()
    {
        assertFalse( areIdTypesValidForBinaryExpression( new BooleanType(), new BooleanType() ) );
    }

    private boolean areIdTypesValidForBinaryExpression( Type leftType, Type rightType )
    {
        Map<String, Type> types = new HashMap<String, Type>();
        String leftQuestionId = "leftQuestionId";
        types.put( leftQuestionId, leftType );
        String rightQuestionId = "rightQuestionId";
        types.put( rightQuestionId, rightType );
        IdExpression idExpression1 = new IdExpression( leftQuestionId );
        IdExpression idExpression2 = new IdExpression( rightQuestionId );
        AndExpression andExpression = new AndExpression( idExpression1, idExpression2 );
        return expressionContainsTypeError( andExpression, types, TypeChecker.getBooleanExpressionInvalidTypesList() );
    }

    private boolean expressionContainsTypeError( Expression expression, Map<String, Type> questionsTypes,
                                                 List<Type> expectedTypes )
    {
        ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker();
        expressionTypeChecker.validateType( "", expression, questionsTypes, expectedTypes );
        return !expressionTypeChecker.getErrors().isEmpty();
    }


}
