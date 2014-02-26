package net.iplantevin.ast.expressions;

import net.iplantevin.ast.types.Type;
import net.iplantevin.ast.types.TypeEnvironment;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
 * Parentheses (forced precedence).
 */
public class Par extends Expression {
    private final Expression expression;

    public Par(Expression expression, ParserRuleContext ctx) {
        super(ctx);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public Type getType(TypeEnvironment idTypeMap) {
        return this.expression.getType(idTypeMap);
    }

    @Override
    public String toString() {
        return "(" + expression.toString() + ")";
    }

    @Override
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
