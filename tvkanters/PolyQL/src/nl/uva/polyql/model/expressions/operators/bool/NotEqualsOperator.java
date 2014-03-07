package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;

public class NotEqualsOperator extends BooleanOperator {

    public static final String SYNTAX = "!=";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public BooleanValue performOperation(final BooleanValue left, final BooleanValue right) {
        return new BooleanValue(!left.equals(right));
    }

    @Override
    public BooleanValue performOperation(final NumberValue left, final NumberValue right) {
        return new BooleanValue(!left.equals(right));
    }

    @Override
    public BooleanValue performOperation(final StringValue left, final StringValue right) {
        return new BooleanValue(!left.equals(right));
    }

    @Override
    public boolean isValidForImplementedType(final Type type) {
        return true;
    }

}
