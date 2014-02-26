package edu.uva.softwarecons.model.expression.bool;

import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.operation.Operator;
import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class AndExpression extends BinaryExpression {

    public AndExpression(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
        operator = Operator.AND;
    }

    @Override
    public Type eval() {
        return null;
    }
}
