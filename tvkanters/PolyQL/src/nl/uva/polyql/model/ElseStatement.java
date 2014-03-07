package nl.uva.polyql.model;

import nl.uva.polyql.model.expressions.Expression;

public class ElseStatement extends IfStatement {

    protected ElseStatement(final RuleContainer parent, final Expression expression) {
        super(parent, expression);
    }

    @Override
    public boolean isSatisfied() {
        return !super.isSatisfied();
    }

    @Override
    public String toString() {
        return "ELSE " + mExpression;
    }

}
