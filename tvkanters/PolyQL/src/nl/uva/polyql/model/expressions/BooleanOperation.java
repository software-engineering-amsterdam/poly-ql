package nl.uva.polyql.model.expressions;

import nl.uva.polyql.model.Type;

public class BooleanOperation extends Operation<Boolean> {

    public BooleanOperation(final Expression left, final String operator, final Expression right) {
        super(left, operator, right);
    }

    @Override
    public Type getReturnType() {
        return Type.BOOLEAN;
    }
}
