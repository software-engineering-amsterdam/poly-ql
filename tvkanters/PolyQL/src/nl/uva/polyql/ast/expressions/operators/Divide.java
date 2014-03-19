package nl.uva.polyql.ast.expressions.operators;

import nl.uva.polyql.ast.expressions.operations.BinaryOperator;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.Value;

public class Divide extends BinaryOperator {

    public static final String SYNTAX = "/";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public Value<?> performOperation(final NumberValue left, final NumberValue right) {
        return new NumberValue(left.getValue() / right.getValue());
    }

}
