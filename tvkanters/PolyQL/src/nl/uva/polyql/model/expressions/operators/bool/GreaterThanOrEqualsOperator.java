package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;

public class GreaterThanOrEqualsOperator extends BooleanOperator {

    public static final String SYNTAX = ">=";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public BooleanValue performOperation(final NumberValue left, final NumberValue right) {
        return new BooleanValue(left.getValue() >= right.getValue());
    }

    @Override
    public boolean isValidForImplementedType(final Type type) {
        return type == Type.NUMBER;
    }

}
