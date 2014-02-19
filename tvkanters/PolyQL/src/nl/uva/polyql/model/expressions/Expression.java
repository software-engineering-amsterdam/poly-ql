package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Type;

public abstract class Expression {

    public abstract Type getReturnType();

    protected abstract Object getValue();

    public boolean getBooleanValue() {
        return (Boolean) getValue();
    }

    public double getNumberValue() {
        return (Double) getValue();
    }
}
