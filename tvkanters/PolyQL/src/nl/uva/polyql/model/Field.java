package nl.uva.polyql.model;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.validation.InvalidTypeError;
import nl.uva.polyql.validation.ValidationErrors;
import nl.uva.polyql.view.ValueView;

public class Field extends Question implements Question.ValueListener {

    private final Expression mExpression;

    protected Field(final RuleContainer parent, final String id, final String label, final String type,
            final Expression expression) {
        super(parent, id, label, type);

        mExpression = expression;
        setValue(expression.getValue());

        for (final Question question : mExpression.getReferencedQuestions()) {
            question.addUpdateListener(this);
        }
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        mExpression.validate();
        setValue(mExpression.getValue());
    }

    @Override
    public ValueView getView() {
        final ValueView view = super.getView();
        addUpdateListener(view);
        return view;
    }

    @Override
    public ValidationErrors validate() {
        final ValidationErrors errors = mExpression.validate();
        if (!errors.isFatal()) {
            if (mExpression.getReturnType() != getType()) {
                errors.add(new InvalidTypeError(getType(), mExpression.getReturnType()));
            }
        }
        return errors;
    }
}
