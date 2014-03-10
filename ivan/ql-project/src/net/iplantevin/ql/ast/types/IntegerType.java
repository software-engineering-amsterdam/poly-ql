package net.iplantevin.ql.ast.types;

/**
 * Integer is only compatible to itself.
 *
 * @author Ivan
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
    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "integer";
    }
}
