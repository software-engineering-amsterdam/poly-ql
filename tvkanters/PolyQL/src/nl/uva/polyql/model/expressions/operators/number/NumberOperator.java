package nl.uva.polyql.model.expressions.operators.number;

import nl.uva.polyql.model.expressions.operators.SameOperandOperator;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.Value;

public abstract class NumberOperator extends SameOperandOperator<NumberValue> {

    @Override
    public NumberValue performOperation(final Type operandType, final Value<?> leftValue, final Value<?> rightValue) {
        return leftValue.performOperationOnLeft(this, rightValue);
    }

    public abstract NumberValue performOperation(final NumberValue left, final NumberValue right);

    @Override
    public boolean isValid(final Type type) {
        return type == Type.NUMBER;
    }
}
