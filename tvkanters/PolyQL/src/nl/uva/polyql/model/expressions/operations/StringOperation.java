package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.OperatorHelper;
import nl.uva.polyql.model.types.Type;
import nl.uva.polyql.model.values.StringValue;

public class StringOperation extends Operation<StringValue> {

    public StringOperation(final Expression left, final String operator, final Expression right) {
        super(left, operator, right);
    }

    @Override
    public Type getReturnType() {
        return Type.STRING;
    }

    @Override
    protected Operator<StringValue> getOperator(final String operator) {
        return OperatorHelper.getStringOperator(operator);
    }

    public static boolean isValid(final Type leftType, final String operator, final Type rightType) {
        return Operation.isValid(leftType, OperatorHelper.getStringOperator(operator), rightType);
    }

}
