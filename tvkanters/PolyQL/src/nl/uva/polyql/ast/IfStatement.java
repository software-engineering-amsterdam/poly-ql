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

public class IfStatement extends RuleContainer implements Rule, Question.ValueListener {

    private final RuleContainer mParent;
    private final Expression mExpression;
    private boolean mSatisfied;
    private LineInfo mLineInfo;

    private final Set<SatisfactionListener> mSatisfactionListeners = new HashSet<>();

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
        mSatisfactionListeners.add(view);
        view.onSatisfactionUpdate(this);
        return view.getComponent();
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        mExpression.validate();
        final boolean satisfied = checkSatisfaction();

        if (satisfied != mSatisfied) {
            mSatisfied = satisfied;

            for (final SatisfactionListener listener : mSatisfactionListeners) {
                listener.onSatisfactionUpdate(this);
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
        for (final Rule rule : getRules()) {
            errors.merge(rule.validate());
        }

        return errors;
    }

    private boolean checkSatisfaction() {
        return ((BooleanValue) mExpression.getValue()).getValue();
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

    /**
     * The interface for objects wanting to be notified of satisfaction changes of the if-statement.
     */
    public interface SatisfactionListener {

        /**
         * Called when an if-statement's visibility changed.
         * 
         * @param ifStatement
         *            The caller
         */
        public void onSatisfactionUpdate(final IfStatement ifStatement);
    }
}
