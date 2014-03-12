package nl.uva.polyql.model.expressions.operators;

import nl.uva.polyql.model.expressions.operations.Operator;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.Value;

public class And extends Operator {

    public static final String SYNTAX = "&&";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public Value<?> performOperation(final BooleanValue left, final BooleanValue right) {
        return new BooleanValue(left.getValue() && right.getValue());
    }

}
