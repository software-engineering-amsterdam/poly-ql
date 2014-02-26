package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.operators.SameOperandOperator;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;
import nl.uva.polyql.model.values.Value;

public abstract class BooleanOperator extends SameOperandOperator<BooleanValue> {

    @Override
    public BooleanValue performOperation(final Type operandType, final Value<?> leftValue, final Value<?> rightValue) {
        return leftValue.performOperationOnLeft(this, rightValue);
    }

    public abstract BooleanValue performOperation(final BooleanValue left, final BooleanValue right);

    public abstract BooleanValue performOperation(final NumberValue left, final NumberValue right);

    public abstract BooleanValue performOperation(final StringValue left, final StringValue right);

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
