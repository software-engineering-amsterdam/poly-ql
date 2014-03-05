package edu.uva.softwarecons.model.expression.arithmetic;

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
public class DivExpression extends BinaryExpression {

    public DivExpression(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
        operator = Operator.DIV;
    }


    @Override
    public Type eval() {
        return null;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitDivExpression(this);
    }
}
