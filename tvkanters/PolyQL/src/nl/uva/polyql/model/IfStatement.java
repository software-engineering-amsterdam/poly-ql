package nl.uva.polyql.model;

import nl.uva.polyql.model.expressions.Expression;

public class IfStatement extends RuleContainer {

    private Expression mExpression;

    protected IfStatement(final RuleContainer parent) {
        super(parent);
    }

    public void setExpression(final Expression expression) {
        mExpression = expression;
    }

}
