package net.iplantevin.ast.statements;

import net.iplantevin.ast.expressions.Expression;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
 * IfElse statement. Adds a body for the else to the Conditional body.
 */
public class IfElse extends Conditional {
    private final Statement elseBody;

    public IfElse(Expression condition, Statement body, Statement elseBody, ParserRuleContext ctx) {
        super(condition, body, ctx);

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
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
