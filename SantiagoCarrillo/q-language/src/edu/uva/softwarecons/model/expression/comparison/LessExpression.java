package edu.uva.softwarecons.model.expression.comparison;

import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.IExpressionEvalVisitor;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/20/14
 */
public class LessExpression
    extends BinaryExpression
{

    public LessExpression( Expression leftOperand, Expression rightOperand )
    {
        super( leftOperand, rightOperand );
    }

    @Override
    public Type accept( IExpressionElementVisitor visitor )
    {
        return visitor.visitLessExpression( this );
    }

    @Override
    public Value accept( IExpressionEvalVisitor visitor )
    {
        return visitor.visitLessExpression( this );
    }
}
