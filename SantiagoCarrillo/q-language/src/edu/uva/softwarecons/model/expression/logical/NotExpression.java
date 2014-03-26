package edu.uva.softwarecons.model.expression.logical;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.UnaryExpression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.ExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.ExpressionEvalVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/20/14
 */
public class NotExpression
    extends UnaryExpression
{


    public NotExpression( Expression expression )
    {
        super( expression );
    }

    @Override
    public Type accept( ExpressionElementVisitor visitor )
    {
        return visitor.visitNotExpression( this );
    }

    @Override
    public Value accept( ExpressionEvalVisitor visitor )
    {
        return visitor.visitNotExpression( this );
    }
}
