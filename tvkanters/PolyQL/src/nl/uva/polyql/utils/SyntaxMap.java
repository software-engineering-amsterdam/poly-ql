package nl.uva.polyql.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps objects to their syntax representation.
 * 
 * @param <T>
 *            The type of objects to map
 */
public class SyntaxMap<T extends SyntaxKey> {

    private final Map<String, T> sSyntaxMap = new HashMap<>();

    public void put(final T syntaxKey) {
        sSyntaxMap.put(syntaxKey.getSyntax(), syntaxKey);
    }

    public T get(final String syntax) {
        return sSyntaxMap.get(syntax);
    }

    public boolean contains(final String syntax) {
        return sSyntaxMap.containsKey(syntax);
    }

}
