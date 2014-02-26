package net.iplantevin.ast.types;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan
 * Date: 19-02-14
 * String is only compatible with itself.
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
    public String toString() {
        return "string";
    }
}
