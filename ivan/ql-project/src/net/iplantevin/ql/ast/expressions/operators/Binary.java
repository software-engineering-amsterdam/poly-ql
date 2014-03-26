package net.iplantevin.ql.ast.expressions.operators;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;

/**
 * Parent class of all binary expressions. Has two expressions (left and right).
 *
 * @author Ivan
 */
public abstract class Binary extends Expression {
    private final Expression leftHS;
    private final Expression rightHS;

    protected Binary(Expression left, Expression right, LineInfo lineInfo) {
        super(lineInfo);
        leftHS = left;
        rightHS = right;
    }

    public Expression getLeftHS() {
        return leftHS;
    }

    public Expression getRightHS() {
        return rightHS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Binary binary = (Binary) o;

        if (!leftHS.equals(binary.getRightHS())) return false;
        if (!rightHS.equals(binary.getRightHS())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = leftHS.hashCode();
        result = 31 * result + rightHS.hashCode();
        return result;
    }
}
