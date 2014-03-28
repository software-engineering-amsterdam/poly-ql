package edu.uva.softwarecons.evaluator;

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
import edu.uva.softwarecons.model.value.ArithmeticValue;
import edu.uva.softwarecons.model.value.BooleanValue;
import edu.uva.softwarecons.model.value.ComparableValue;
import edu.uva.softwarecons.model.value.IntegerValue;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.ExpressionEvalVisitor;

import java.util.HashMap;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public class ExpressionEvaluator
    implements ExpressionEvalVisitor
{


    private HashMap<String, Value> context = new HashMap<String, Value>();

    public ExpressionEvaluator()
    {
    }

    public void addContextValue( String key, Value value )
    {
        context.put( key, value );
    }

    @Override
    public Value visitAddExpression( AddExpression expression )
    {
        return ( (ArithmeticValue) expression.getLeftExpression().accept( this ) ).
            add( expression.getRightExpression().accept( this ) );
    }

    @Override
    public Value visitDivExpression( DivExpression expression )
    {
        return ( (ArithmeticValue) expression.getLeftExpression().accept( this ) ).
            divide( expression.getRightExpression().accept( this ) );
    }

    @Override
    public Value visitMulExpression( MulExpression expression )
    {
        return ( (ArithmeticValue) expression.getLeftExpression().accept( this ) ).
            multiply( expression.getRightExpression().accept( this ) );
    }

    @Override
    public Value visitSubExpression( SubExpression expression )
    {
        return ( (ArithmeticValue) expression.getLeftExpression().accept( this ) ).
            subtract( expression.getRightExpression().accept( this ) );
    }

    @Override
    public Value visitAndExpression( AndExpression expression )
    {
        return ( (BooleanValue) expression.getLeftExpression().accept( this ) ).
            and( expression.getRightExpression().accept( this ) );
    }

    @Override
    public Value visitOrExpression( OrExpression expression )
    {
        return ( (BooleanValue) expression.getLeftExpression().accept( this ) ).
            or( expression.getRightExpression().accept( this ) );
    }

    @Override
    public Value visitNotExpression( NotExpression expression )
    {
        return ( (BooleanValue) expression.getArgument().accept( this ) ).not();
    }

    @Override
    public Value visitEqualExpression( EqualExpression expression )
    {
        return new BooleanValue( expression.getLeftExpression().accept( this ).
            equals( expression.getRightExpression().accept( this ) ) );
    }

    @Override
    public Value visitNotEqualExpression( NotEqualExpression expression )
    {
        return new BooleanValue( !expression.getLeftExpression().accept( this ).
            equals( expression.getRightExpression().accept( this ) ) );
    }

    @Override
    public Value visitGreaterEqualExpression( GreaterEqualExpression expression )
    {
        return new BooleanValue( ( (ComparableValue) expression.getLeftExpression().accept( this ) ).
            greaterEqual( expression.getRightExpression().accept( this ) ) );
    }

    @Override
    public Value visitGreaterExpression( GreaterExpression expression )
    {
        return new BooleanValue( ( (ComparableValue) expression.getLeftExpression().accept( this ) ).
            greater( expression.getRightExpression().accept( this ) ) );
    }

    @Override
    public Value visitLessEqualExpression( LessEqualExpression expression )
    {
        return new BooleanValue( ( (ComparableValue) expression.getLeftExpression().accept( this ) ).
            lessEqual( expression.getRightExpression().accept( this ) ) );
    }

    @Override
    public Value visitLessExpression( LessExpression expression )
    {
        return new BooleanValue( ( (ComparableValue) expression.getLeftExpression().accept( this ) ).
            less( expression.getRightExpression().accept( this ) ) );
    }

    @Override
    public Value visitIdExpression( IdExpression expression )
    {
        return context.get( expression.getId() );
    }

    @Override
    public Value visitBoolExpression( BoolExpression expression )
    {
        return new BooleanValue( expression.getValue() );
    }

    @Override
    public Value visitIntExpression( IntExpression expression )
    {
        return new IntegerValue( expression.getValue() );
    }
}
