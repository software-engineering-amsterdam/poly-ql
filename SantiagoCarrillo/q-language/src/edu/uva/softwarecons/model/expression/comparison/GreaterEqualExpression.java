package edu.uva.softwarecons.model.expression.comparison;

import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.Expression;
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
public class GreaterEqualExpression
    extends BinaryExpression
{

    public GreaterEqualExpression( Expression leftOperand, Expression rightOperand )
    {
        super( leftOperand, rightOperand );
    }

    @Override
    public BinaryExpression getNewInstance( Expression leftOperand, Expression rightOperand )
    {
        return new GreaterEqualExpression( leftOperand, rightOperand );
    }

    @Override
    public Type accept( ExpressionElementVisitor visitor )
    {
        return visitor.visitGreaterEqualExpression( this );
    }

    @Override
    public Value accept( ExpressionEvalVisitor visitor )
    {
        return visitor.visitGreaterEqualExpression( this );
    }
}
