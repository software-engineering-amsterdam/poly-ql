package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.operation.Operator;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.IFormElement;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public abstract class UnaryExpression implements Expression, IFormElement {

    private Expression expression;


    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }

}
