package net.iplantevin.ast.expressions.operators;

import net.iplantevin.ast.LineInfo;
import net.iplantevin.ast.expressions.Expression;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
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
