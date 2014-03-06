package nl.uva.polyql.model;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.view.ValueView;

public class Field extends Question implements Question.OnUpdateListener {

    private final Expression mExpression;

    protected Field(final RuleContainer parent, final String id, final String label, final Expression expression) {
        super(parent, id, label, expression.getReturnType());

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
        setValue(mExpression.getValue());

        // TODO: Update displayed value of the field
    }

    @Override
    public ValueView<?> getView() {
        final ValueView<?> view = super.getView();
        addUpdateListener(view);
        return view;
    }
}
