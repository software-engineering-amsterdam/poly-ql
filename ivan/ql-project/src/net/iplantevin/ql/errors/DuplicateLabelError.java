package net.iplantevin.ql.errors;

import net.iplantevin.ql.ast.statements.Questionable;

/**
 * @author Ivan
 */
public class DuplicateLabelError extends ASTError {
    private final Questionable originalQuestionable;
    private final Questionable newQuestionable;

    public DuplicateLabelError(String message, Questionable newQuestionable, Questionable originalQuestionable) {
        super(message, null);
        this.originalQuestionable = originalQuestionable;
        this.newQuestionable = newQuestionable;
    }

    @Override
    public String toString() {
        return "DUPLICATE LABEL warning: " + getMessage() + "\n" +
                "Label at location " + newQuestionable.getLabel().getLineInfo() +
                " in question:\n" +
                newQuestionable +
                "already used in question:\n" +
                originalQuestionable +
                "at location " + originalQuestionable.getLineInfo() + "\n";
    }
}
