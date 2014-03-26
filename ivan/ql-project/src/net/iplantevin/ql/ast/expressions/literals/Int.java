package net.iplantevin.ql.ast.expressions.literals;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.typechecking.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IExpressionVisitor;

/**
 * Integer.
 *
 * @author Ivan
 */
public class Int extends Expression {
    private final Integer value;

    public Int(Integer value, LineInfo lineInfo) {
        super(lineInfo);
        this.value = value;
    }

    @Override
    public Type getType(TypeEnvironment idTypeStore) {
        return new IntegerType();
    }

    public int getValue() {
        return value.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Int anInt = (Int) o;

        if (!value.equals(anInt.value)) return false;

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
