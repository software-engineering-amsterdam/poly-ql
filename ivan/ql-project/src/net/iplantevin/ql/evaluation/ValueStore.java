package net.iplantevin.ql.evaluation;

import java.util.HashMap;
import java.util.Map;

/**
 * This helper class is a wrapper for a map between identifiers (string values)
 * and their value (Value object).
 */
class ValueStore {
    private final Map<String, Value> values;

    public ValueStore() {
        values = new HashMap<String, Value>();
    }

    public void store(String identifier, Value value) {
        values.put(identifier, value);
    }

    public Value get(String identifier) {
        if (values.containsKey(identifier)) {
            return values.get(identifier);
        } else {
            // Todo: actual Value of null type?
            return null;
        }
    }
}