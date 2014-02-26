package net.iplantevin.ast.types;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 19-02-14
 * Boolean is only compatible with itself.
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
    public boolean equals(Object obj) {
        return obj instanceof BooleanType;
    }

    @Override
    public String toString() {
        return "boolean";
    }
}
