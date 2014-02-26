package net.iplantevin.ast.statements;

import net.iplantevin.ast.expressions.Expression;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @user: Ivan
 * @date: 19-02-14
 * If statement.
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
