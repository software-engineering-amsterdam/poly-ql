package nl.uva.polyql.model.expressions.operators.number;

import nl.uva.polyql.model.values.NumberValue;

public class DivideOperator extends NumberOperator {

    public static final String SYNTAX = "/";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public NumberValue performOperation(final NumberValue left, final NumberValue right) {
        return new NumberValue(left.getValue() / right.getValue());
    }

}
