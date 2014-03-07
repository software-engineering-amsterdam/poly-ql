package nl.uva.polyql.utils;

/**
 * An interface for classes that can be mapped by their syntax representation.
 */
public interface SyntaxKey {

    /**
     * Retrieves the syntax used to refer to this class.
     * 
     * @return The class's syntax
     */
    public String getSyntax();
}
