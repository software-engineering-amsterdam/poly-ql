package nl.uva.polyql.model;

import nl.uva.polyql.model.expressions.Expression;

public class ElseStatement extends IfStatement {

    protected ElseStatement(final RuleContainer parent, final Expression expression) {
        super(parent, expression);
    }

    @Override
    public boolean isVisible() {
        return !isSatisfied() && getParent().isVisible();
    }

    @Override
    public String toString() {
        return "ELSE " + mExpression;
    }

}
