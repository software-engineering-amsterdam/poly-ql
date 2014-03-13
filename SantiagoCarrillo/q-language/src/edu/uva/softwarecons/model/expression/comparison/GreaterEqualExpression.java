package edu.uva.softwarecons.model.expression.comparison;

import edu.uva.softwarecons.exception.CompareException;
import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.expression.IExpressionEvalVisitor;
import edu.uva.softwarecons.visitor.form.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class GreaterEqualExpression extends BinaryExpression{

    public GreaterEqualExpression(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type accept(IExpressionElementVisitor visitor) {
        return visitor.visitGreaterEqualExpression(this);
    }

    @Override
    public Value accept(IExpressionEvalVisitor visitor) throws CompareException {
        return visitor.visitGreaterEqualExpression(this);
    }
}
