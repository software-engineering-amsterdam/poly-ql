package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;
import edu.uva.softwarecons.visitor.form.IFormElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
//TODO SHOULD BE REMOVEDs
public class ParenthesisExpression implements Expression {

    private final Expression argument;

    public ParenthesisExpression(Expression argument) {
        this.argument = argument;
    }

    @Override
    public Expression eval() {
        return argument.eval();
    }

    public Expression getArgument() {
        return argument;
    }

    @Override
    public Type accept(IExpressionElementVisitor visitor) {
        return visitor.visitParenthesisExpression(this);
    }
}
