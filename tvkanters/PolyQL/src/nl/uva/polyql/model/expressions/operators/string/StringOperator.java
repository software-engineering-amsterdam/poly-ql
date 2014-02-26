package nl.uva.polyql.model.expressions.operators.string;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;

public abstract class StringOperator extends Operator<StringValue> {

    @Override
    protected StringValue performOperation(final Expression left, final Expression right) {
        return left.getValue().performOperationOnLeft(this, right.getValue());
    }

    public abstract StringValue performOperation(final StringValue left, final StringValue right);

    public abstract StringValue performOperation(final StringValue left, final NumberValue right);

    public abstract StringValue performOperation(final NumberValue left, final StringValue right);

    @Override
    public boolean isValid(final Type leftType, final Type rightType) {
        boolean valid = true;

        switch (leftType) {
        case STRING:
        case NUMBER:
            break;
        default:
            valid = false;
        }

        switch (rightType) {
        case STRING:
        case NUMBER:
            break;
        default:
            valid = false;
        }

        return valid;
    }
}
