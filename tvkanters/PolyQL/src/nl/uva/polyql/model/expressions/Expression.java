package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Rule;
import nl.uva.polyql.model.Type;

public abstract class Expression {

    private final Rule mParentRule;

    public Expression(final Rule parentRule) {
        mParentRule = parentRule;
    }

    public abstract Type getReturnType();

    protected abstract Object getValue();

    public boolean getBooleanValue() {
        return (Boolean) getValue();
    }

    public double getNumberValue() {
        return (Double) getValue();
    }

    public Rule getParent() {
        return mParentRule;
    }
}
