package edu.uva.softwarecons.model.expression.bool;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.UnaryExpression;
import edu.uva.softwarecons.visitor.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class NotExpression extends UnaryExpression {


    public NotExpression(Expression expression) {
        super(expression);
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitNotExpression(this);
    }
}
