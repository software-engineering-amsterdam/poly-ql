package nl.uva.polyql.model.expressions.operations;

import nl.uva.polyql.model.Types;
import nl.uva.polyql.model.expressions.Expression;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.OperatorHelper;

public class NumberOperation extends Operation<Double> {

    public NumberOperation(final Expression left, final String operator, final Expression right) {
        super(left, operator, right);
    }

    @Override
    public Types getReturnType() {
        return Types.NUMBER;
    }

    @Override
    protected Operator<Double> getOperator(final String operator) {
        return OperatorHelper.getNumberOperator(operator);
    }

}
