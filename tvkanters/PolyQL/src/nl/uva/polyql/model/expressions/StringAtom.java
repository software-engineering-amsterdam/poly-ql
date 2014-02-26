package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.values.StringValue;

public class StringAtom extends Expression {

    private final StringValue mValue;

    public StringAtom(final String value) {
        // Strip out the quotes
        mValue = (StringValue) Type.STRING.parseInput(value);
    }

    @Override
    public Type getReturnType() {
        return Type.STRING;
    }

    @Override
    public StringValue getValue() {
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
