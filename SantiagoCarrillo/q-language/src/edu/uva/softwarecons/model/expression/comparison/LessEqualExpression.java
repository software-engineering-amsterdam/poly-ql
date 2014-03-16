package edu.uva.softwarecons.model.expression.comparison;

import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.IExpressionEvalVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class LessEqualExpression extends BinaryExpression{


    public LessEqualExpression(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type accept(IExpressionElementVisitor visitor) {
        return visitor.visitLessEqualExpression(this);
    }

    @Override
    public Value accept(IExpressionEvalVisitor visitor) {
        return visitor.visitLessEqualExpression(this);
    }
}
