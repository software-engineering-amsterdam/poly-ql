package nl.uva.polyql.model.expressions.operators.string;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.types.Type;
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
        return leftType == Type.STRING && rightType == Type.STRING || leftType == Type.NUMBER
                && rightType == Type.STRING || leftType == Type.STRING && rightType == Type.NUMBER;
    }
}
