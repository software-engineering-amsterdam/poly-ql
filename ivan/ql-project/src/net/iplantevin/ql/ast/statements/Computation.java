package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
 * Computed question. In addition to name, label and type, also has an Expression.
 */
public class Computation extends Questionable {
    private final Expression expression;

    public Computation(ID name, Str label, Type type, Expression expression, ParserRuleContext ctx) {
        super(name, label, type, ctx);

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
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
