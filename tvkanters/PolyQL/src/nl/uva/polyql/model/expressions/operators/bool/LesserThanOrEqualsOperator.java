package nl.uva.polyql.model.expressions.operators.bool;

import nl.uva.polyql.model.Type;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;

public class LesserThanOrEqualsOperator extends BooleanOperator {

    public static final String SYNTAX = "<=";

    @Override
    public String getSyntax() {
        return SYNTAX;
    }

    @Override
    protected Boolean performOperation(boolean left, boolean right) {
        throw new UnsupportedOperandTypeException(Type.BOOLEAN, SYNTAX);
    }

    @Override
    protected Boolean performOperation(double left, double right) {
        return left <= right;
    }

    @Override
    protected Boolean performOperation(String left, String right) {
        throw new UnsupportedOperandTypeException(Type.STRING, SYNTAX);
    }

    @Override
    public boolean isValidForImplementedType(final Type type) {
        return type == Type.NUMBER;
    }

}
