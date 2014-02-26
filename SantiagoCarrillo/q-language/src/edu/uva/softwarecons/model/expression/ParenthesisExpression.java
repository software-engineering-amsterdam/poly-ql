package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.visitor.IFormElement;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class ParenthesisExpression implements Expression, IFormElement {

    Expression expression;

    public ParenthesisExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {

    }
}
