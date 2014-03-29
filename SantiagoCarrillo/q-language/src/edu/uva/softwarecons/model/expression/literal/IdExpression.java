package edu.uva.softwarecons.model.expression.literal;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.ExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.ExpressionEvalVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/26/14
 */
public class IdExpression
    implements Expression
{

    private final String id;

    public IdExpression( String id )
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    @Override
    public Type accept( ExpressionElementVisitor visitor )
    {
        return visitor.visitIdExpression( this );
    }

    @Override
    public boolean equals( Object o )
    {
        return o instanceof IdExpression;
    }


    @Override
    public Value accept( ExpressionEvalVisitor visitor )
    {
        return visitor.visitIdExpression( this );
    }
}
