package edu.uva.softwarecons.model.expression.comparison;

import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class EqualExpression extends BinaryExpression{

    public EqualExpression(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Expression eval() {
        return null;
    }

    @Override
    public Type accept(IExpressionElementVisitor visitor) {
        return visitor.visitEqualExpression(this);
    }
}
