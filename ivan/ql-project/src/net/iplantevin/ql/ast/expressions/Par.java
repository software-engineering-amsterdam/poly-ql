package net.iplantevin.ql.ast.expressions;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IASTVisitor;

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
    public String toString() {
        return "(" + expression.toString() + ")";
    }

    @Override
    public void accept(IASTVisitor visitor) {
        visitor.visit(this);
    }
}
