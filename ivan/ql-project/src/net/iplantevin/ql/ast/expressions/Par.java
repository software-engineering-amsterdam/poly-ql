package net.iplantevin.ql.ast.expressions;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.typechecking.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IExpressionVisitor;

/**
 * Parentheses (forced precedence).
 *
 * @author Ivan
 */
public class Par extends Expression {
    private final Expression expression;

    public Par(Expression expression, LineInfo lineInfo) {
        super(lineInfo);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public Type getType(TypeEnvironment idTypeStore) {
        return this.expression.getType(idTypeStore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Par par = (Par) o;

        if (!expression.equals(par.expression)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return expression.hashCode();
    }

    @Override
    public String toString() {
        return "(" + expression.toString() + ")";
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
