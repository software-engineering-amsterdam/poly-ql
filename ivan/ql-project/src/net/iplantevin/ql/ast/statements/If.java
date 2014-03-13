package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.visitors.IStatementVisitor;

/**
 * If statement.
 *
 * @author Ivan
 */
public class If extends Conditional {
    public If(Expression condition, Statement body, LineInfo lineInfo) {
        super(condition, body, lineInfo);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
