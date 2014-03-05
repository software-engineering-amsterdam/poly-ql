package edu.uva.softwarecons.model.expression.logical;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.UnaryExpression;
import edu.uva.softwarecons.model.type.Type;
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

    @Override
    public Type eval() {
        return null;
    }
}
