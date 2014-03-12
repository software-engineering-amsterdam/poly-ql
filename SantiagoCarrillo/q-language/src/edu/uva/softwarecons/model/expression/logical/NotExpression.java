package edu.uva.softwarecons.model.expression.logical;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.expression.UnaryExpression;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.form.IFormElementVisitor;

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
    public Expression eval() {
        return null;
    }

    @Override
    public Type accept(IExpressionElementVisitor visitor) {
        return visitor.visitNotExpression(this);
    }
}
