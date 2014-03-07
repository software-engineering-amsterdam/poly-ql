package nl.uva.polyql.model;

import nl.uva.polyql.exceptions.InvalidIfStatementTypeException;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;

public class IfStatement extends RuleContainer implements Question.ValueListener {

    protected final Expression mExpression;
    private boolean mSatisfied;

    protected IfStatement(final RuleContainer parent, final Expression expression) {
        super(parent);

        if (expression.getReturnType() != Type.BOOLEAN) {
            throw new InvalidIfStatementTypeException(expression.getReturnType());
        }

        mExpression = expression;
        mSatisfied = checkSatisfaction();

        for (final Question question : mExpression.getReferencedQuestions()) {
            question.addUpdateListener(this);
        }
    }

    @Override
    public boolean isVisible() {
        return mSatisfied && getParent().isVisible();
    }

    public boolean isSatisfied() {
        return mSatisfied;
    }

    private boolean checkSatisfaction() {
        return ((BooleanValue) mExpression.getValue()).getValue();
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        final boolean oldVisible = isVisible();
        final boolean satisfied = checkSatisfaction();

        if (satisfied != mSatisfied) {
            mSatisfied = satisfied;

            final boolean newVisible = isVisible();
            if (oldVisible != newVisible) {
                onParentVisibilityUpdate(newVisible);
            }
        }
    }

    @Override
    public void onParentVisibilityUpdate(final boolean visible) {
        final boolean statementVisible = isVisible();
        for (final Rule rule : getChildRules()) {
            rule.onParentVisibilityUpdate(statementVisible);
        }
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
