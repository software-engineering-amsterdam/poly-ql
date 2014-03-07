package net.iplantevin.ql.ast.types;

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

    @Override
    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
