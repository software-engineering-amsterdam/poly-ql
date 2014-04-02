package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;

/**
 * Conditional statement, parent for If and IfElse statements. Has condition
 * and body.
 *
 * @author Ivan
 */
public abstract class Conditional extends Statement {
    private final Expression condition;
    private final Statement body;

    protected Conditional(Expression condition, Statement body, LineInfo lineInfo) {
        super(lineInfo);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conditional that = (Conditional) o;

        if (!body.equals(that.body)) return false;
        if (!condition.equals(that.condition)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = condition.hashCode();
        result = 31 * result + body.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "if(" + condition.toString() + ") " + body.toString();
    }
}
