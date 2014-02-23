package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.RuleContainer;
import nl.uva.polyql.model.Type;

public class QuestionAtom extends Expression {

    private final Question mQuestion;
    private final Modifier mModifier;

    public QuestionAtom(final RuleContainer parentRuleContainer, final String id, final String modifier) {
        mQuestion = parentRuleContainer.getQuestion(id);
        if (mQuestion == null) {
            throw new RuntimeException("Unknown question ID " + id);
        }

        mModifier = Modifier.getBySyntax(modifier);
        if (!mModifier.isValid(mQuestion.getType())) {
            throw new RuntimeException("Unsupported modifier " + mModifier + " for type " + mQuestion.getType());
        }
    }

    @Override
    public Type getReturnType() {
        return mQuestion.getType();
    }

    @Override
    public Object getValue() {
        return mModifier.apply(mQuestion);
    }

    @Override
    public String toString() {
        return mModifier.getSyntax() + mQuestion.getId() + " = " + getValue();
    }

    @Override
    public Set<Question> getReferencedQuestions() {
        final Set<Question> questions = new HashSet<>();
        questions.add(mQuestion);
        return questions;
    }
}
