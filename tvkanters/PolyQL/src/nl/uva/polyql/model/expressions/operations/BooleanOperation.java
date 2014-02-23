package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.OperatorHelper;

public class BooleanOperation extends Operation<Boolean> {

    public BooleanOperation(final Expression left, final String operator, final Expression right) {
        super(left, operator, right);
    }

    @Override
    public Type getReturnType() {
        return Type.BOOLEAN;
    }

    @Override
    protected Operator<Boolean> getOperator(final String operator) {
        return OperatorHelper.getBooleanOperator(operator);
    }

    public static boolean isValid(final Type leftType, final String operator, final Type rightType) {
        return Operation.isValid(leftType, OperatorHelper.getBooleanOperator(operator), rightType);
    }
}
