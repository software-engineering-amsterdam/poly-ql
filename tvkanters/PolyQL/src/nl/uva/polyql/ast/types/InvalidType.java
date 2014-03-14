package nl.uva.polyql.ast.types;

import nl.uva.polyql.ast.values.InvalidValue;

public class InvalidType extends ValueType<InvalidValue> {

    public InvalidType() {
        super(null);
    }

    @Override
    public InvalidValue parseInput(final String input) {
        return null;
    }
}
