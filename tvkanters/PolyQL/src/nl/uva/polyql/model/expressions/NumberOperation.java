package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Rule;
import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.OperatorManager;

public class NumberOperation extends Operation<Double> {

    public NumberOperation(final Rule parentRule, final Expression left, final String operator, final Expression right) {
        super(parentRule, left, operator, right);
    }

    @Override
    public Type getReturnType() {
        return Type.NUMBER;
    }

    @Override
    protected Operator<Double> getOperator(final String operator) {
        return OperatorManager.getNumberOperator(operator);
    }

}
