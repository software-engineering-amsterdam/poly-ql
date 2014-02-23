package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.OperatorHelper;

public class NumberOperation extends Operation<Double> {

    public NumberOperation(final Expression left, final String operator, final Expression right) {
        super(left, operator, right);
    }

    @Override
    public Type getReturnType() {
        return Type.NUMBER;
    }

    @Override
    protected Operator<Double> getOperator(final String operator) {
        return OperatorHelper.getNumberOperator(operator);
    }

    public static boolean isValid(final Type leftType, final String operator, final Type rightType) {
        return Operation.isValid(leftType, OperatorHelper.getNumberOperator(operator), rightType);
    }

}
