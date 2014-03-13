package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.types.BooleanType;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.validation.ValidationErrors;

public class BooleanAtom extends Expression {

    private final BooleanValue mValue;

    public BooleanAtom(final String value) {
        mValue = new BooleanType().parseInput(value);
    }

    @Override
    public Type getReturnType() {
        return Type.BOOLEAN;
    }

    @Override
    public BooleanValue getValue() {
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

    @Override
    public ValidationErrors validate() {
        return new ValidationErrors();
    }

}
