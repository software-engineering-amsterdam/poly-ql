package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Type;

public class StringAtom extends Expression {

    private final String mValue;

    public StringAtom(final String value) {
        // Strip out the quotes
        mValue = (String) Type.STRING.parseInput(value);
    }

    @Override
    public Type getReturnType() {
        return Type.STRING;
    }

    @Override
    public String getValue() {
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
