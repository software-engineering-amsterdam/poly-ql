package nl.uva.polyql.model.expressions.operators.number;

import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.Value;

public class MultiplyOperator extends Operator {

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
