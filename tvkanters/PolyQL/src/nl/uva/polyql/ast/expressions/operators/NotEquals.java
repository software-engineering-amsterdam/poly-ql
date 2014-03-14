package nl.uva.polyql.ast.expressions.operators;

import nl.uva.polyql.ast.expressions.operations.Operator;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;
import nl.uva.polyql.ast.values.Value;

public class NotEquals extends Operator {

    public static final String SYNTAX = "!=";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public Value<?> performOperation(final BooleanValue left, final BooleanValue right) {
        return new BooleanValue(!left.equals(right));
    }

    @Override
    public Value<?> performOperation(final NumberValue left, final NumberValue right) {
        return new BooleanValue(!left.equals(right));
    }

    @Override
    public Value<?> performOperation(final StringValue left, final StringValue right) {
        return new BooleanValue(!left.equals(right));
    }

}
