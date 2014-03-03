package net.iplantevin.ql.ast.expressions.operators;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.BooleanType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IASTVisitor;

/**
 * Negation. Type is Integer.
 *
 * @author Ivan
 */
public class Not extends Unary {
    public Not(Expression expression, LineInfo lineInfo) {
        super(expression, lineInfo);
    }

    @Override
    public Type getType(TypeEnvironment idTypeStore) {
        return new BooleanType();
    }

    @Override
    public String toString() {
        return "!" + getExpression();
    }

    @Override
    public void accept(IASTVisitor visitor) {
        visitor.visit(this);
    }
}
