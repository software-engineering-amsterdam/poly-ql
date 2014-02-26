package net.iplantevin.exceptions;

import net.iplantevin.ast.statements.Questionable;

/**
 * @author Ivan
 */
public class QLDuplicateLabelException extends QLASTException {
    private final Questionable originalQuestionable;
    private final Questionable newQuestionable;

    public QLDuplicateLabelException(String message, Questionable newQuestionable, Questionable originalQuestionable) {
        super(message, null);
        this.originalQuestionable = originalQuestionable;
        this.newQuestionable = newQuestionable;
    }

    @Override
    public String toString() {
        return "Duplicate label warning: " + getMessage() + "\n" +
                "Label at location " + newQuestionable.getLabel().getLineInfo() +
                " in question:\n" +
                newQuestionable +
                "already used in question:\n" +
                originalQuestionable +
                "at location " + originalQuestionable.getLineInfo();
    }
}
