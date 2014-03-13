package nl.uva.polyql.ast;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.validation.InvalidIfStatementError;
import nl.uva.polyql.validation.ValidationErrors;

public class IfStatement extends RuleContainer implements Rule, Question.ValueListener {

    private final RuleContainer mParent;

    protected final Expression mExpression;
    private boolean mSatisfied;
    private LineInfo mLineInfo;

    protected IfStatement(final RuleContainer parent, final Expression expression) {
        mParent = parent;

        mExpression = expression;

        for (final Question question : mExpression.getReferencedQuestions()) {
            question.addUpdateListener(this);
        }
    }

    @Override
    public boolean isVisible() {
        return mSatisfied && getParent().isVisible();
    }

    public Expression getExpression() {
        return mExpression;
    }

    @Override
    public void setLineInfo(final LineInfo lineInfo) {
        mLineInfo = lineInfo;
    }

    @Override
    public LineInfo getLineInfo() {
        return mLineInfo;
    }

    @Override
    public RuleContainer getParent() {
        return mParent;
    }

    public boolean isSatisfied() {
        return mSatisfied;
    }

    private boolean checkSatisfaction() {
        return ((BooleanValue) mExpression.getValue()).getValue();
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        mExpression.validate();

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
    public ValidationErrors validate() {
        // Validate expression
        final ValidationErrors errors = mExpression.validate();
        if (!errors.isFatal()) {
            if (mExpression.getReturnType() != Type.BOOLEAN) {
                errors.add(new InvalidIfStatementError(this));
            } else {
                mSatisfied = checkSatisfaction();
            }
        }

        // Validate children
        for (final Rule rule : getChildRules()) {
            errors.merge(rule.validate());
        }

        return errors;
    }
}
