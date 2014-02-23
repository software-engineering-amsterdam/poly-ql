package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Types;

public class StringAtom extends Expression {

    private final String mValue;

    public StringAtom(final String value) {
        // Strip out the quotes
        mValue = (String) Types.STRING.parseInput(value);
    }

    @Override
    public Types getReturnType() {
        return Types.STRING;
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
