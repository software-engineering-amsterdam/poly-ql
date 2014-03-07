package nl.uva.polyql.model.expressions.operators.string;

import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;

public class AddOperator extends StringOperator {

    public static final String SYNTAX = "+";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public StringValue performOperation(final StringValue left, final StringValue right) {
        return new StringValue(left.getValue() + right.getValue());
    }

    @Override
    public StringValue performOperation(final StringValue left, final NumberValue right) {
        return new StringValue(left.getValue() + right.getValue());
    }

    @Override
    public StringValue performOperation(final NumberValue left, final StringValue right) {
        return new StringValue(left.getValue() + right.getValue());
    }

}
