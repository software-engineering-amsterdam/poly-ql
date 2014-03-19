package edu.uva.softwarecons.model.expression.logical;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.UnaryExpression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.IExpressionEvalVisitor;

/**
 * Falconlabs
 * @author Santiago Carrillo
 * Date: 2/20/14
 */
public class NotExpression
    extends UnaryExpression
{


    public NotExpression( Expression expression )
    {
        super( expression );
    }

    @Override
    public Type accept( IExpressionElementVisitor visitor )
    {
        return visitor.visitNotExpression( this );
    }

    @Override
    public Value accept( IExpressionEvalVisitor visitor )
    {
        return visitor.visitNotExpression( this );
    }
}
