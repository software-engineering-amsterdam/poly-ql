package net.iplantevin.ast.expressions.operators;

import net.iplantevin.ast.LineInfo;
import net.iplantevin.ast.expressions.Expression;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
 * Parent class of all binary expressions. Has two expressions (left and right).
 */
public abstract class Binary extends Expression {
    private final Expression leftExpr;
    private final Expression rightExpr;

    protected Binary(Expression left, Expression right, LineInfo lineInfo) {
        super(lineInfo);
        leftExpr = left;
        rightExpr = right;
    }

    public Expression getLeftExpr() {
        return leftExpr;
    }

    public Expression getRightExpr() {
        return rightExpr;
    }
}
