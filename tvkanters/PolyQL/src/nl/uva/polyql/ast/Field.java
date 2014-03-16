package nl.uva.polyql.ast;

import java.awt.Component;

import nl.uva.polyql.ast.expressions.Expression;
import nl.uva.polyql.validation.InvalidTypeError;
import nl.uva.polyql.validation.ValidationErrors;
import nl.uva.polyql.view.QuestionView;

public class Field extends Question implements Question.ValueListener {

    private final Expression mExpression;

    protected Field(final RuleContainer parent, final String id, final String label, final String type,
            final Expression expression) {
        super(parent, id, label, type);

        mExpression = expression;

        for (final Question question : mExpression.getReferencedQuestions()) {
            question.addUpdateListener(this);
        }
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        mExpression.validate();
        setValue(mExpression.getValue());
    }

    @Override
    public Component getView() {
        final QuestionView view = getValue().getView(this);
        addUpdateListener(view);
        return view.getComponent();
    }

    @Override
    public ValidationErrors validate() {
        final ValidationErrors errors = mExpression.validate();
        if (!errors.isFatal()) {
            if (mExpression.getReturnType() != getType()) {
                errors.add(new InvalidTypeError(this));
            } else {
                setValue(mExpression.getValue());
            }
        }
        return errors;
    }

    public Expression getExpression() {
        return mExpression;
    }

    @Override
    public boolean isEditable() {
        return false;
    }
}
