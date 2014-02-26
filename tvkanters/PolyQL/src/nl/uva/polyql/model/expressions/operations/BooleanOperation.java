package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.OperatorHelper;
import nl.uva.polyql.model.values.BooleanValue;

public class BooleanOperation extends Operation<BooleanValue> {

    public BooleanOperation(final Expression left, final String operator, final Expression right) {
        super(left, operator, right);
    }

    @Override
    public Type getReturnType() {
        return Type.BOOLEAN;
    }

    @Override
    protected Operator<BooleanValue> getOperator(final String operator) {
        return OperatorHelper.getBooleanOperator(operator);
    }

    public static boolean isValid(final Type leftType, final String operator, final Type rightType) {
        return Operation.isValid(leftType, OperatorHelper.getBooleanOperator(operator), rightType);
    }
}
