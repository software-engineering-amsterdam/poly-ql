package net.iplantevin.ql.ast.expressions.literals;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.BooleanType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.typechecking.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IExpressionVisitor;

/**
 * Boolean.
 *
 * @author Ivan
 */
public class Bool extends Expression {
    private final Boolean value;

    public Bool(boolean value, LineInfo lineInfo) {
        super(lineInfo);
        this.value = value;
    }

    @Override
    public Type getType(TypeEnvironment idTypeStore) {
        return new BooleanType();
    }

    public boolean getValue() {
        return value.booleanValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bool bool = (Bool) o;

        if (!value.equals(bool.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
