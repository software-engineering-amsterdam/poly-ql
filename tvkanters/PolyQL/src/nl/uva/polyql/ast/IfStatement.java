package nl.uva.polyql.ast;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.ast.expressions.Expression;
import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.validation.InvalidIfStatementError;
import nl.uva.polyql.validation.ValidationErrors;
import nl.uva.polyql.view.IfStatementView;

public class IfStatement extends RuleContainer implements Rule, VisibilityListener, Question.ValueListener {

    private final RuleContainer mParent;
    private final Expression mExpression;
    private boolean mSatisfied;
    private LineInfo mLineInfo;

    private final Set<VisibilityListener> mVisibilityListeners = new HashSet<>();

    protected IfStatement(final RuleContainer parent, final Expression expression) {
        mParent = parent;
        mExpression = expression;

        for (final Question question : mExpression.getReferencedQuestions()) {
            question.addUpdateListener(this);
        }
    }

    @Override
    public Component getView() {
        final IfStatementView view = new IfStatementView(this);
        mVisibilityListeners.add(view);
        view.onParentVisibilityUpdate(isVisible());
        return view.getComponent();
    }

    @Override
    public void onParentVisibilityUpdate(final boolean visible) {
        for (final VisibilityListener listener : mVisibilityListeners) {
            listener.onParentVisibilityUpdate(visible);
        }
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

    private boolean checkSatisfaction() {
        return ((BooleanValue) mExpression.getValue()).getValue();
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

    @Override
    public String toString() {
        return "IF " + mExpression;
    }
}
