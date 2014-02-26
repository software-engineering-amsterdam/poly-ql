package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.expressions.operators.SameOperandOperator;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.model.values.Value;

public abstract class BooleanOperator extends SameOperandOperator<BooleanValue> {

    @Override
    public BooleanValue performOperation(final Type operandType, final Value<?> leftValue, final Value<?> rightValue) {
        return leftValue.performOperationOnLeft(this, rightValue);
    }

    public BooleanValue performOperation(final BooleanValue left, final BooleanValue right) {
        throw new UnsupportedOperandTypeException(Type.BOOLEAN, getSyntax());
    }

    public BooleanValue performOperation(final NumberValue left, final NumberValue right) {
        throw new UnsupportedOperandTypeException(Type.NUMBER, getSyntax());
    }

    public BooleanValue performOperation(final StringValue left, final StringValue right) {
        throw new UnsupportedOperandTypeException(Type.STRING, getSyntax());
    }

    @Override
    public boolean isValid(final Type type) {
        switch (type) {
        case BOOLEAN:
        case NUMBER:
        case STRING:
            return isValidForImplementedType(type);
        default:
            return false;
        }
    }

    public abstract boolean isValidForImplementedType(final Type type);
}
