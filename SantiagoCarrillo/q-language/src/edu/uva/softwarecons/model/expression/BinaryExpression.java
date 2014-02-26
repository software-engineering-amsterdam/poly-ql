package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.operation.Operator;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.IFormElement;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public abstract class BinaryExpression implements Expression, IFormElement {

    protected Expression leftOperand;

    protected Expression rightOperand;

    protected Operator operator;


    protected BinaryExpression(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public abstract Type eval();
}
