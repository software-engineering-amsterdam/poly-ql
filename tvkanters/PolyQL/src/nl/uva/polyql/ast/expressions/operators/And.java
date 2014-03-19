package nl.uva.polyql.ast.expressions.operators;

import nl.uva.polyql.ast.expressions.operations.BinaryOperator;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.Value;

public class And extends BinaryOperator {

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
