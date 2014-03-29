package net.iplantevin.ql.ast.statements;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.visitors.IStatementVisitor;

/**
 * Regular questionnaire question.
 *
 * @author Ivan
 */
public class Question extends Questionable {
    public Question(ID identifier, Str label, Type type, LineInfo lineInfo) {
        super(identifier, label, type, lineInfo);
    }

    @Override
    public String toString() {
        return super.toString() + "\n";
    }

    @Override
    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
