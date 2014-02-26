package net.iplantevin.ql.ast.types;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 19-02-14
 * Integer is only compatible to itself.
 */
public class IntegerType extends Type {
    @Override
    public boolean isCompatibleToInteger() {
        return true;
    }

    @Override
    public boolean isCompatibleToType(Type type) {
        return type.isCompatibleToInteger();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof IntegerType;
    }

    @Override
    public String toString() {
        return "integer";
    }
}
