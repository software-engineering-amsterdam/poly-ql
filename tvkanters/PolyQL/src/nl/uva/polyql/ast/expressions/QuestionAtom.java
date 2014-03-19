package nl.uva.polyql.ast.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.RuleContainer;
import nl.uva.polyql.ast.values.Type;
import nl.uva.polyql.ast.values.Value;
import nl.uva.polyql.validation.UnknownIdError;
import nl.uva.polyql.validation.ValidationErrors;

public class QuestionAtom extends Expression {

    private final String mQuestionId;
    private final Question mQuestion;

    public QuestionAtom(final RuleContainer parentRuleContainer, final String id) {
        mQuestionId = id;
        mQuestion = parentRuleContainer.getQuestion(id);
    }

    public String getId() {
        return mQuestionId;
    }

    @Override
    public Type getReturnType() {
        return mQuestion.getType();
    }

    @Override
    public Value<?> getValue() {
        return mQuestion.getValue();
    }

    @Override
    public String toString() {
        return (mQuestion != null ? mQuestion.getId() : "No ID");
    }

    @Override
    public Set<Question> getReferencedQuestions() {
        final Set<Question> questions = new HashSet<>();
        if (mQuestion != null) {
            questions.add(mQuestion);
        }
        return questions;
    }

    @Override
    public ValidationErrors validate() {
        final ValidationErrors errors = new ValidationErrors();
        if (mQuestion == null) {
            errors.add(new UnknownIdError(this));
        }
        return errors;
    }

    @Override
    public boolean isValid() {
        return getReturnType() != Type.INVALID;
    }
}
