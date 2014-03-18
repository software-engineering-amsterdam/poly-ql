package edu.uva.softwarecons.model.expression.literal;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.IExpressionEvalVisitor;

/**
 * Falconlabs
 * @author Santiago Carrillo
 * Date: 2/26/14
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
    public Type accept( IExpressionElementVisitor visitor )
    {
        return visitor.visitIdExpression( this );
    }

    @Override
    public boolean equals( Object o )
    {
        return o instanceof IdExpression;
    }


    @Override
    public Value accept( IExpressionEvalVisitor visitor )
    {
        return visitor.visitIdExpression( this );
    }
}
