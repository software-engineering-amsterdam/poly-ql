package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.visitors.IASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * If statement.
 *
 * @author Ivan
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
    public void accept(IASTVisitor visitor) {
        visitor.visit(this);
    }
}
