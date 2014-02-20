package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.RuleContainer;
import nl.uva.polyql.model.Type;

public class IdAtom extends Expression {

    private Question mQuestion;
    private final String mId;

    public IdAtom(final RuleContainer parentRuleContainer, final String id, final String modifier) {
        mId = id;

        mQuestion = parentRuleContainer.getQuestion(mId);
        if (mQuestion == null) {
            throw new RuntimeException("Unknown question ID " + mId);
        }
    }

    @Override
    public Type getReturnType() {
        return mQuestion.getType();
    }

    @Override
    public Object getValue() {
        return mQuestion.getValue();
    }

    @Override
    public String toString() {
        return mQuestion.toString();
    }

    @Override
    public Set<Question> getReferencedQuestions() {
        final Set<Question> questions = new HashSet<>();
        questions.add(mQuestion);
        return questions;
    }
}
