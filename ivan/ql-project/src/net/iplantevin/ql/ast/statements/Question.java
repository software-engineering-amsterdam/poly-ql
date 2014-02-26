package net.iplantevin.ast.statements;

import net.iplantevin.ast.expressions.literals.ID;
import net.iplantevin.ast.expressions.literals.Str;
import net.iplantevin.ast.types.Type;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created with IntelliJ IDEA.
 *
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
