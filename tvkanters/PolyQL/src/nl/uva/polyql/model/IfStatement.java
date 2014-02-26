package nl.uva.polyql.model;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;

public class IfStatement extends RuleContainer implements Question.OnUpdateListener {

    protected final Expression mExpression;

    protected IfStatement(final RuleContainer parent, final Expression expression) {
        super(parent);

        if (parent == null) {
            throw new RuntimeException("If-statements must have a parent");
        }

        if (expression.getReturnType() != Type.BOOLEAN) {
            throw new RuntimeException("Invalid if-statement expression type: " + expression.getReturnType());
        }

        mExpression = expression;

        for (final Question question : mExpression.getReferencedQuestions()) {
            question.addUpdateListener(this);
        }
    }

    public boolean isSatisfied() {
        return ((BooleanValue) mExpression.getValue()).getValue();
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        // TODO: Update visibility of the statement
    }

    @Override
    public String toString() {
        return "IF " + mExpression;
    }

    @Override
    public boolean addLabel(final String label) {
        return getParent().addLabel(label);
    }

}
