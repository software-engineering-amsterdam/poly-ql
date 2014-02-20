package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.Type;

public class NumberAtom extends Expression {

    private final double mValue;

    public NumberAtom(final String value) {
        mValue = Double.parseDouble(value);
    }

    @Override
    public Type getReturnType() {
        return Type.NUMBER;
    }

    @Override
    public Double getValue() {
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
