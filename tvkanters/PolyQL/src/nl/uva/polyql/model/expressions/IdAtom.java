package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Rule;
import nl.uva.polyql.model.Type;

public class IdAtom extends Expression {

    private Question mQuestion;
    private final String mId;

    public IdAtom(final Rule parentRule, final String id, final String modifier) {
        super(parentRule);
        
        mId = id;

        mQuestion = parentRule.getQuestion(mId);
        if (mQuestion == null) {
            throw new RuntimeException("Unknown question ID " + mId);
        }
    }

    @Override
    public Type getReturnType() {
        return mQuestion.getType();
    }

    @Override
    protected Object getValue() {
        return mQuestion.getValue();
    }

    @Override
    public String toString() {
        return "QVAL";
    }

    private enum Modifier {
        INVERSE,
        NEGATIVE;
    }
}
