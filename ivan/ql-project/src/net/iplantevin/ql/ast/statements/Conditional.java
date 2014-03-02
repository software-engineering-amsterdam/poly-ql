package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.expressions.Expression;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Conditional statement, parent for If and IfElse statements. Has condition
 * and body.
 *
 * @author Ivan
 */
public abstract class Conditional extends Statement {
    private final Expression condition;
    private final Statement body;

    protected Conditional(Expression condition, Statement body, ParserRuleContext ctx) {
        super(ctx);
        this.condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "if(" + condition.toString() + ") " + body.toString();
    }
}
