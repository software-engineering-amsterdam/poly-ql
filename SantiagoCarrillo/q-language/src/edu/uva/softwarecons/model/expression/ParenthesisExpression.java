package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.form.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class ParenthesisExpression implements Expression {

    private final Expression argument;

    public ParenthesisExpression(Expression argument) {
        this.argument = argument;
    }

    @Override
    public Type eval() {
        return null;
    }

    public Expression getArgument() {
        return argument;
    }

    @Override
    public void accept(IExpressionElementVisitor visitor) {
        visitor.visitParenthesisExpression(this);
    }
}
