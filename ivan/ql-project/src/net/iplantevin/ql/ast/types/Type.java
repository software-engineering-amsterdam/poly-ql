package net.iplantevin.ql.ast.types;

/**
 * Abstract class for types. Defines default compatibility methods that
 * determine what types can be combined in expressions (default compatible with
 * nothing). Abstract method |isCompatibleTo| must be implemented by subclasses.
 * <p/>
 * Implements ASTNode interface for visiting.
 *
 * @author Ivan
 */
public abstract class Type {
    public boolean isCompatibleToBoolean() {
        return false;
    }

    public boolean isCompatibleToInteger() {
        return false;
    }

    public boolean isCompatibleToString() {
        return false;
    }

    /**
     * Use to determine whether a certain type is compatible with another.
     * (Should return true for own type)
     *
     * @param type the type.
     * @return true or false.
     */
    public abstract boolean isCompatibleToType(Type type);

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object object);

    public abstract <T> T accept(ITypeVisitor<T> visitor);
}
