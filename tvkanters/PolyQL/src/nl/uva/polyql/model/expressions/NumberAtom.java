package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Type;

public class NumberAtom extends Expression {

    private final double mValue;

    public NumberAtom(final double value) {
        mValue = value;
    }

    public NumberAtom(final String value) {
        mValue = Double.parseDouble(value);
    }

    @Override
    public Type getReturnType() {
        return Type.NUMBER;
    }

    @Override
    protected Double getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return getValue().toString();
    }

}
