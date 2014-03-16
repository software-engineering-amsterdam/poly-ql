package nl.uva.polyql.ast.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.validation.ValidationErrors;

public class BooleanAtom extends Expression {

    private final BooleanValue mValue;

    public BooleanAtom(final String value) {
        mValue = new BooleanValue(Boolean.parseBoolean(value));
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
