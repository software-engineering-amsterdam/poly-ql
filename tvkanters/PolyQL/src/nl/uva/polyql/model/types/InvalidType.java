package nl.uva.polyql.model.types;

import nl.uva.polyql.model.values.InvalidValue;

public class InvalidType extends ValueType<InvalidValue> {

    public InvalidType() {
        super(null);
    }

    @Override
    public InvalidValue parseInput(final String input) {
        return null;
    }
}
