package nl.uva.polyql.model;

import nl.uva.polyql.model.expressions.Expression;

public class ElseStatement extends IfStatement {

    protected ElseStatement(final RuleContainer parent, final Expression expression) {
        super(parent, expression);
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        // Inverse expression boolean here
        // TODO: Update visibility of the statement
    }

    @Override
    public String toString() {
        return "ELSE " + mExpression;
    }

}
