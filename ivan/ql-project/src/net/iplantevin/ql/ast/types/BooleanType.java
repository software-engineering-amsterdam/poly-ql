package net.iplantevin.ql.ast.types;

/**
 * Boolean is only compatible with itself.
 *
 * @author Ivan
 */
public class BooleanType extends Type {

    @Override
    public boolean isCompatibleToBoolean() {
        return true;
    }

    @Override
    public boolean isCompatibleToType(Type type) {
        return type.isCompatibleToBoolean();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof BooleanType;
    }

    @Override
    public String toString() {
        return "boolean";
    }
}
