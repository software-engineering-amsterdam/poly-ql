package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * @author Ivan
 *         If statement.
 */
public class If extends Conditional {
    public If(Expression condition, Statement body, ParserRuleContext ctx) {
        super(condition, body, ctx);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
