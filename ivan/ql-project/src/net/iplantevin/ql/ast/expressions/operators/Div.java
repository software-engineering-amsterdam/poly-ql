package net.iplantevin.ql.ast.expressions.operators;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.typechecking.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IExpressionVisitor;

/**
 * Division.
 *
 * @author Ivan
 */
public class Div extends Binary {
    public Div(Expression left, Expression right, LineInfo lineInfo) {
        super(left, right, lineInfo);
    }

    @Override
    public Type getType(TypeEnvironment idTypeStore) {
        return new IntegerType();
    }

    @Override
    public String toString() {
        return getLeftHS() + " / " + getRightHS();
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
