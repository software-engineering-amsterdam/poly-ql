package net.iplantevin.ast.types;

/**
 * @author Ivan
 */
public class UndefinedType extends Type {
    @Override
    public boolean isCompatibleToType(Type type) {
        return false;
    }

    @Override
    public String toString() {
        return "undefined";
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof UndefinedType;
    }
}
