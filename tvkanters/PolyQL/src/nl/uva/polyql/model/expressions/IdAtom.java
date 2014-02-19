package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Type;

public class IdAtom extends Expression {

    private final Question mQuestion;

    public IdAtom(final String id) {
        mQuestion = new Question();
        mQuestion.setId(id);
        mQuestion.setContent("foo");
        mQuestion.setType(Type.BOOLEAN);
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
}
