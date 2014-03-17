package edu.uva.softwarecons.model.expression.arithmetic;

import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.form.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class DivExpression extends BinaryExpression {

    public DivExpression(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    public Type eval() {
        return null;
    }

    @Override
    public void accept(IExpressionElementVisitor visitor) {
        visitor.visitDivExpression(this);
    }
}