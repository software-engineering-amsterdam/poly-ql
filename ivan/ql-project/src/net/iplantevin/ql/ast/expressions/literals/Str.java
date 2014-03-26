package net.iplantevin.ql.ast.expressions.literals;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.StringType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.typechecking.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IExpressionVisitor;

/**
 * String.
 *
 * @author Ivan
 */
public class Str extends Expression {
    private final String text;

    public Str(String text, LineInfo lineInfo) {
        super(lineInfo);
        this.text = text.substring(1, text.length() - 1);
    }

    @Override
    public Type getType(TypeEnvironment idTypeStore) {
        return new StringType();
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Str str = (Str) o;

        if (!text.equals(str.text)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }

    @Override
    public String toString() {
        return String.format("\"%s\"", text);
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
