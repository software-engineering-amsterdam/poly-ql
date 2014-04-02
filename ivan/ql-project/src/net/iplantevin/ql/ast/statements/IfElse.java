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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IfElse that = (IfElse) o;

        if (!getBody().equals(that.getBody())) return false;
        if (!getCondition().equals(that.getCondition())) return false;
        if (!elseBody.equals(that.getElseBody())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + elseBody.hashCode();
        return result;
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
