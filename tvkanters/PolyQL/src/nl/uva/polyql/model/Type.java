package nl.uva.polyql.model;

public enum Type {
    BOOLEAN, MONEY;
    
    public static Type fromString(final String string) {
        return Type.valueOf(string.toUpperCase());
    }
}
