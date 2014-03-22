package edu.uva.softwarecons.model.expression.literal;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.ExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.ExpressionEvalVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/12/14
 */
public class BoolExpression
    implements Expression
{

    private final boolean value;


    public BoolExpression( boolean value )
    {
        this.value = value;
    }

    @Override
    public Type accept( ExpressionElementVisitor visitor )
    {
        return new BooleanType();
    }

    @Override
    public Value accept( ExpressionEvalVisitor visitor )
    {
        return visitor.visitBoolExpression( this );
    }

    @Override
    public boolean equals( Object obj )
    {
        return obj instanceof BoolExpression;
    }

    public boolean getValue()
    {
        return value;
    }


}
