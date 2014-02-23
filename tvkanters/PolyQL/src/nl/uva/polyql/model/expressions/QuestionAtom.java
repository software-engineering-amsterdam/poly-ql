package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.RuleContainer;
import nl.uva.polyql.model.Types;

public class QuestionAtom extends Expression {

    private Question mQuestion;

    public QuestionAtom(final RuleContainer parentRuleContainer, final String id, final String modifier) {
        mQuestion = parentRuleContainer.getQuestion(id);
        if (mQuestion == null) {
            throw new RuntimeException("Unknown question ID " + id);
        }
    }

    @Override
    public Types getReturnType() {
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
