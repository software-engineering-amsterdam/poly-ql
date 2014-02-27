package net.iplantevin.ql.ast.expressions.operators;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IQLASTVisitor;

/**
 * @author  Ivan
 * Unary +. Type is integer.
 */
public class Pos extends Unary {
    public Pos(Expression expression, LineInfo lineInfo) {
        super(expression, lineInfo);
    }

    @Override
    public Type getType(TypeEnvironment idTypeMap) {
        return new IntegerType();
    }

    @Override
    public String toString() {
        return "+" + getExpression();
    }

    @Override
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
