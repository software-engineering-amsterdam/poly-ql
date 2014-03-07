package nl.uva.polyql.model;

import nl.uva.polyql.model.expressions.Expression;

public class Field extends Question implements Question.OnUpdateListener {

    private Expression mExpression;

    protected Field(final RuleContainer parent, final String id, final String label, final Expression expression) {
        super(parent, id, label, expression.getReturnType());

        mExpression = expression;
        setValue(expression.getValue());

        for (final Question question : mExpression.getReferencedQuestions()) {
            question.addUpdateListener(this);
        }
    }

    @Override
    public void onQuestionUpdate(final Question question) {
        setValue(mExpression.getValue());

        // TODO: Update displayed value of the field
    }
}
