package nl.uva.polyql.model.expressions.operators.number;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.operators.Operator;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public abstract class NumberOperator extends Operator<Double> {

    @Override
    protected Double performOperation(boolean left, boolean right) {
        throw new UnsupportedOperandTypeException(Type.BOOLEAN);
    }
}
