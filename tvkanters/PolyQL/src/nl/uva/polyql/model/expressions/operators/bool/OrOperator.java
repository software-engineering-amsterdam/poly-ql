package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;

public class OrOperator extends BooleanOperator {

    public static final String SYNTAX = "||";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    public BooleanValue performOperation(final BooleanValue left, final BooleanValue right) {
        return new BooleanValue(left.getValue() || right.getValue());
    }

    @Override
    public BooleanValue performOperation(final NumberValue left, final NumberValue right) {
        throw new UnsupportedOperandTypeException(Type.NUMBER, SYNTAX);
    }

    @Override
    public BooleanValue performOperation(final StringValue left, final StringValue right) {
        throw new UnsupportedOperandTypeException(Type.STRING, SYNTAX);
    }

    @Override
    public boolean isValidForImplementedType(final Type type) {
        return type == Type.BOOLEAN;
    }

}
