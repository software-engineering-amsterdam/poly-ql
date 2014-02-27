package net.iplantevin.ql.ast.expressions.operators;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;

/**
 * @author  Ivan
 * Parent class of all unary expressions. Unary expressions have a single
 * expression.
 */
public abstract class Unary extends Expression {
    private final Expression expression;

    protected Unary(Expression expression, LineInfo lineInfo) {
        super(lineInfo);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }
}
