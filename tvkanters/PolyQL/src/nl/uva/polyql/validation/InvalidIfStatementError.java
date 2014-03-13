package nl.uva.polyql.validation;

import nl.uva.polyql.model.types.Type;

public class InvalidIfStatementError extends ValidationError {

    private final Type mType;

    public InvalidIfStatementError(final Type type) {

        mType = type;
    }

    @Override
    public String toString() {
        return "Invalid if-statement expression type: " + mType + ", should be " + Type.BOOLEAN;
    }
}
