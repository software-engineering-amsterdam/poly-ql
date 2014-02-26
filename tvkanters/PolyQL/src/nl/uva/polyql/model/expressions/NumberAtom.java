package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.values.NumberValue;

public class NumberAtom extends Expression {

    private final NumberValue mValue;

    public NumberAtom(final String value) {
        mValue = (NumberValue) Type.NUMBER.parseInput(value);
    }

    @Override
    public Type getReturnType() {
        return Type.NUMBER;
    }

    @Override
    public NumberValue getValue() {
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
