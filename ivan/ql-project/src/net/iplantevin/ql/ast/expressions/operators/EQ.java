package net.iplantevin.ast.expressions.operators;

import net.iplantevin.ast.LineInfo;
import net.iplantevin.ast.expressions.Expression;
import net.iplantevin.ast.types.BooleanType;
import net.iplantevin.ast.types.Type;
import net.iplantevin.ast.types.TypeEnvironment;
import net.iplantevin.ast.visitors.IQLASTVisitor;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
 * Equality.
 */
public class EQ extends Binary {
    public EQ(Expression left, Expression right, LineInfo lineInfo) {
        super(left, right, lineInfo);
    }

    @Override
    public Type getType(TypeEnvironment idTypeMap) {
        return new BooleanType();
    }

    @Override
    public String toString() {
        return getLeftExpr() + " == " + getRightExpr();
    }

    @Override
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
