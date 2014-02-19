package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Type;

public class NumberOperation extends Operation<Double> {

    public NumberOperation(final Expression left, final String operator, final Expression right) {
        super(left, operator, right);
    }

    @Override
    public Type getReturnType() {
        return Type.NUMBER;
    }

}
