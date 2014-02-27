package edu.uva.softwarecons.model.expression.bool;

import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.operation.Operator;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class OrExpression extends BinaryExpression{

    public OrExpression(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
        operator = Operator.OR;
    }


    @Override
    public Type eval() {
        return null;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitOrExpression(this);
    }
}
