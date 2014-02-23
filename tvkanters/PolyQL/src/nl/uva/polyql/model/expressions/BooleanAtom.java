package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Type;

public class BooleanAtom extends Expression {

    private final boolean mValue;

    public BooleanAtom(final String value) {
        mValue = (Boolean) Type.BOOLEAN.parseInput(value);
    }

    @Override
    public Type getReturnType() {
        return Type.BOOLEAN;
    }

    @Override
    public Boolean getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return getValue().toString();
    }

    @Override
    public Set<Question> getReferencedQuestions() {
        return new HashSet<>();
    }

}
