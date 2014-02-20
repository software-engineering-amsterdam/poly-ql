package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Rule;
import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.OperatorManager;

public class BooleanOperation extends Operation<Boolean> {

    public BooleanOperation(final Rule parentRule, final Expression left, final String operator, final Expression right) {
        super(parentRule, left, operator, right);
    }

    @Override
    public Type getReturnType() {
        return Type.BOOLEAN;
    }

    @Override
    protected Operator<Boolean> getOperator(final String operator) {
        return OperatorManager.getBooleanOperator(operator);
    }
}
