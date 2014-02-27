package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * @author Ivan
 *         Regular questionnaire question.
 */
public class Question extends Questionable {
    public Question(ID name, Str label, Type type, ParserRuleContext ctx) {
        super(name, label, type, ctx);
    }

    @Override
    public String toString() {
        return super.toString() + "\n";
    }

    @Override
    public void accept(IQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
