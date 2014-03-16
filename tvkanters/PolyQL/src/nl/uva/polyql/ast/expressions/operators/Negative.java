package nl.uva.polyql.ast.expressions.operators;

import nl.uva.polyql.ast.expressions.operations.UnaryOperator;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.Value;

public class Negative extends UnaryOperator {

    public static final String SYNTAX = "-";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public Value<?> performOperation(final NumberValue value) {
        return new NumberValue(-value.getValue());
    }

}
