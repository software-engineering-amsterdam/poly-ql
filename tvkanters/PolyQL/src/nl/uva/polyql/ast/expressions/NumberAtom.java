package nl.uva.polyql.ast.expressions;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.types.NumberType;
import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.validation.ValidationErrors;

public class NumberAtom extends Expression {

    private final NumberValue mValue;

    public NumberAtom(final String value) {
        mValue = new NumberType().parseInput(value);
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

    @Override
    public ValidationErrors validate() {
        return new ValidationErrors();
    }

}
