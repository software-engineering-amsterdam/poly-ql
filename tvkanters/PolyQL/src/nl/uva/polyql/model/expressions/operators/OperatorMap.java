package nl.uva.polyql.model.expressions.operators;

import java.util.HashMap;
import java.util.Map;

public class OperatorMap<T> {

    private final Map<String, Operator<T>> sSyntaxMap = new HashMap<>();

    public void put(final Operator<T> operator) {
        sSyntaxMap.put(operator.getSyntax(), operator);
    }

    public Operator<T> get(final String syntax) {
        return sSyntaxMap.get(syntax);
    }

}
