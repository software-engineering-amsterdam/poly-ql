package net.iplantevin.ql.ast.expressions.literals;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.StringType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IASTVisitor;

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
    public String toString() {
        return String.format("\"%s\"", text);
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
