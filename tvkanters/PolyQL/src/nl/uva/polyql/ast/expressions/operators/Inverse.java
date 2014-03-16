package nl.uva.polyql.ast.expressions.operators;

import nl.uva.polyql.ast.expressions.operations.UnaryOperator;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.Value;

public class Inverse extends UnaryOperator {

    public static final String SYNTAX = "!";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public Value<?> performOperation(final BooleanValue value) {
        return new BooleanValue(!value.getValue());
    }

}
