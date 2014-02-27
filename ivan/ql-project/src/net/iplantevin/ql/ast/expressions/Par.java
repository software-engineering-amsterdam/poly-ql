package net.iplantevin.ql.ast.expressions;

import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * @author Ivan
 *         Parentheses (forced precedence).
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
