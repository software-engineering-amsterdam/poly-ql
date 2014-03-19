package net.iplantevin.ql.ast.types;

/**
 * String is only compatible with itself.
 *
 * @author Ivan
 */
public class StringType extends Type {
    @Override
    public boolean isCompatibleToString() {
        return true;
    }

    @Override
    public boolean isCompatibleToType(Type type) {
        return type.isCompatibleToString();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof StringType;
    }

    @Override
    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "string";
    }
}
