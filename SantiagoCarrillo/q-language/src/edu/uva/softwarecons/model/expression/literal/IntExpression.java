package edu.uva.softwarecons.model.expression.literal;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.ExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.ExpressionEvalVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/3/14
 */
public class IntExpression
    implements Expression
{

    private final int value;

    public IntExpression( int value )
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public Type accept( ExpressionElementVisitor visitor )
    {
        return new IntegerType();
    }

    @Override
    public String toString()
    {
        return String.valueOf( value );
    }

    @Override
    public boolean equals( Object obj )
    {
        return obj instanceof IntExpression;
    }

    @Override
    public Value accept( ExpressionEvalVisitor visitor )
    {
        return visitor.visitIntExpression( this );
    }
}
