package nl.uva.polyql.model;

import nl.uva.polyql.model.expressions.Expression;

public class Field extends Question implements QuestionUpdatedListener {

    private Expression mExpression;

    protected Field(final RuleContainer parent, final String id, final String content, final String type,
            final Expression expression) {
        super(parent, id, content, type);

        mExpression = expression;

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
