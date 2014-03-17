package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.visitors.IStatementVisitor;

/**
 * IfElse statement. Adds a body for the else to the Conditional body.
 *
 * @author Ivan
 */
public class IfElse extends Conditional {
    private final Statement elseBody;

    public IfElse(Expression condition, Statement body, Statement elseBody, LineInfo lineInfo) {
        super(condition, body, lineInfo);

        this.elseBody = elseBody;
    }

    public Statement getElseBody() {
        return elseBody;
    }

    @Override
    public String toString() {
        return super.toString() + "else " + elseBody.toString();
    }

    @Override
    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
