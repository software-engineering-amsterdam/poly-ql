package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Type;
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
}
