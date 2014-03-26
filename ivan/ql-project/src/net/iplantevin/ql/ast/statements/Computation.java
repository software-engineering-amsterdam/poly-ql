package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.visitors.IStatementVisitor;

/**
 * Computed question. In addition to name, label and type, also has an Expression.
 *
 * @author Ivan
 */
public class Computation extends Questionable {
    private final Expression expression;

    public Computation(ID identifier, Str label, Type type, Expression expression, LineInfo lineInfo) {
        super(identifier, label, type, lineInfo);

        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return super.toString() + "(" + expression.toString() + ")\n";
    }

    @Override
    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
