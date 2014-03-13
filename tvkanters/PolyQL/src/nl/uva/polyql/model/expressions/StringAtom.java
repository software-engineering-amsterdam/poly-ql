package nl.uva.polyql.model.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.model.types.StringType;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.validation.ValidationErrors;

public class StringAtom extends Expression {

    private final StringValue mValue;

    public StringAtom(final String value) {
        mValue = new StringType().parseInput(value);
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

    @Override
    public ValidationErrors validate() {
        return new ValidationErrors();
    }

}
