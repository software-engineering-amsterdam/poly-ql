package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.expressions.operations.Operator;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.Value;

public class Multiply extends Operator {

    public static final String SYNTAX = "*";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public Value<?> performOperation(final NumberValue left, final NumberValue right) {
        return new NumberValue(left.getValue() * right.getValue());
    }

}
