package nl.uva.polyql.model.expressions.operators;

import java.util.HashMap;
import java.util.Map;

import nl.uva.polyql.model.values.Value;

public class OperatorMap<T extends Value<?>> {

    private final Map<String, Operator<T>> sSyntaxMap = new HashMap<>();

    public void put(final Operator<T> operator) {
        sSyntaxMap.put(operator.getSyntax(), operator);
    }

    public Operator<T> get(final String syntax) {
        return sSyntaxMap.get(syntax);
    }

    public boolean contains(final String syntax) {
        return sSyntaxMap.containsKey(syntax);
    }

}
