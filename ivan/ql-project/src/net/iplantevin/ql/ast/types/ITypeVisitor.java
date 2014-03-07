package net.iplantevin.ql.ast.types;

/**
 * @author Ivan
 */
public interface ITypeVisitor<T> {
    public T visit(BooleanType booleanType);

    public T visit(IntegerType integerType);

    public T visit(StringType stringType);

    public T visit(UndefinedType undefinedType);
}
