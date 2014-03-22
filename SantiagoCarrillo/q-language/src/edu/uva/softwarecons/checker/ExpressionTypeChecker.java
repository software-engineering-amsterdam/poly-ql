package edu.uva.softwarecons.checker;

import edu.uva.softwarecons.checker.error.InvalidTypeError;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.model.expression.BinaryExpression;
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
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.expression.logical.NotExpression;
import edu.uva.softwarecons.model.expression.logical.OrExpression;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.ExpressionElementVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/3/14
 */


public class ExpressionTypeChecker
    implements ExpressionElementVisitor
{

    private List<QuestionnaireError> errors = new ArrayList<QuestionnaireError>();

    private Map<String, Type> questionTypesContext;

    private String currentQuestionId;


    public void validateType( String questionId, Expression expression, Map<String, Type> questionTypesContext,
                              List<Type> invalidTypes )
    {
        this.currentQuestionId = questionId;
        this.questionTypesContext = questionTypesContext;
        Type type = expression.accept( this );
        containsInvalidType( questionId, invalidTypes, type );

    }

    private void containsInvalidType( String questionId, List<Type> invalidTypes, Type type )
    {
        if ( null != type && null != invalidTypes )
        {
            for ( Type invalidType : invalidTypes )
            {
                if ( type.equals( invalidType ) )
                {
                    errors.add( new InvalidTypeError( questionId, type ) );
                    break;
                }
            }
        }

    }


    @Override
    public Type visitEqualExpression( EqualExpression expression )
    {
        validateBinaryExpressionTypesMatch( expression );
        return new BooleanType();
    }

    @Override
    public Type visitNotEqualExpression( NotEqualExpression expression )
    {
        validateBinaryExpressionTypesMatch( expression );
        return new BooleanType();
    }


    @Override
    public Type visitGreaterEqualExpression( GreaterEqualExpression expression )
    {
        checkBinaryExpressionInvalidTypeError( expression, TypeChecker.getComparableExpressionInvalidTypesList(),
                                               ">=" );
        validateBinaryExpressionTypesMatch( expression );
        return new BooleanType();
    }

    @Override
    public Type visitGreaterExpression( GreaterExpression expression )
    {
        checkBinaryExpressionInvalidTypeError( expression, TypeChecker.getComparableExpressionInvalidTypesList(), ">" );
        validateBinaryExpressionTypesMatch( expression );
        return new BooleanType();
    }

    @Override
    public Type visitLessEqualExpression( LessEqualExpression expression )
    {
        checkBinaryExpressionInvalidTypeError( expression, TypeChecker.getComparableExpressionInvalidTypesList(),
                                               "<=" );
        validateBinaryExpressionTypesMatch( expression );
        return new BooleanType();
    }

    @Override
    public Type visitLessExpression( LessExpression expression )
    {
        checkBinaryExpressionInvalidTypeError( expression, TypeChecker.getComparableExpressionInvalidTypesList(), "<" );
        validateBinaryExpressionTypesMatch( expression );
        return new BooleanType();
    }

    @Override
    public Type visitAndExpression( AndExpression expression )
    {
        return validateBinaryExpressionTypesForGivenType( expression, new BooleanType(), "&&" );
    }

    @Override
    public Type visitOrExpression( OrExpression expression )
    {
        return validateBinaryExpressionTypesForGivenType( expression, new BooleanType(), "||" );
    }

    @Override
    public Type visitNotExpression( NotExpression expression )
    {
        return validateBinaryExpressionTerm( expression.getArgument(), new BooleanType(), "!" );
    }


    @Override
    public Type visitAddExpression( AddExpression expression )
    {
        return validateNumericExpressionType( expression, "+" );
    }

    @Override
    public Type visitMulExpression( MulExpression expression )
    {
        return validateNumericExpressionType( expression, "*" );
    }

    @Override
    public Type visitDivExpression( DivExpression expression )
    {
        return validateNumericExpressionType( expression, "/" );
    }

    @Override
    public Type visitSubExpression( SubExpression expression )
    {
        return validateNumericExpressionType( expression, "-" );
    }


    private Type validateBinaryExpressionTerm( Expression expression, Type expectedType, String operator )
    {
        Type expressionType = expression.accept( this );
        if ( !expectedType.equals( expressionType ) )
        {
            errors.add( new InvalidTypeError( operator, new BooleanType() ) );
        }
        return expressionType;
    }


    @Override
    public Type visitIdExpression( IdExpression idExpression )
    {
        return questionTypesContext.get( idExpression.getId() );
    }


    private void checkBinaryExpressionInvalidTypeError( BinaryExpression expression, List<Type> invalidTypes,
                                                        String operator )
    {
        for ( Type invalidType : invalidTypes )
        {
            checkExpressionInvalidTypeError( expression.getLeftExpression(), invalidType, operator );
            checkExpressionInvalidTypeError( expression.getLeftExpression(), invalidType, operator );
        }
    }

    private void checkExpressionInvalidTypeError( Expression expression, Type invalidType, String operator )
    {
        if ( expression.accept( this ).equals( invalidType ) )
        {
            errors.add( new InvalidTypeError( operator, new BooleanType() ) );
        }
    }

    private Type validateBinaryExpressionTypesMatch( BinaryExpression expression )
    {
        Type leftExpressionType = expression.getLeftExpression().accept( this );
        Type rightExpressionType = expression.getRightExpression().accept( this );
        if ( !leftExpressionType.equals( rightExpressionType ) )
        {
            errors.add( new InvalidTypeError( currentQuestionId, leftExpressionType.toString(),
                                              rightExpressionType.toString() ) );
        }
        return leftExpressionType;
    }

    private Type validateBinaryExpressionTypesForGivenType( BinaryExpression expression, Type expectedType,
                                                            String operand )
    {
        Type leftExpressionType = expression.getLeftExpression().accept( this );
        Type rightExpressionType = expression.getRightExpression().accept( this );
        if ( !leftExpressionType.equals( expectedType ) )
        {
            errors.add( new InvalidTypeError( operand, leftExpressionType ) );
        }
        if ( !rightExpressionType.equals( expectedType ) )
        {
            errors.add( new InvalidTypeError( operand, rightExpressionType ) );
        }
        return leftExpressionType;
    }

    private Type validateNumericExpressionType( BinaryExpression expression, String operator )
    {
        checkBinaryExpressionInvalidTypeError( expression, TypeChecker.getArithmeticExpressionInvalidTypesList(),
                                               operator );
        checkBinaryExpressionInvalidTypeError( expression, TypeChecker.getArithmeticExpressionInvalidTypesList(),
                                               operator );
        return validateBinaryExpressionTypesMatch( expression );
    }

    public List<QuestionnaireError> getErrors()
    {
        return errors;
    }
}
