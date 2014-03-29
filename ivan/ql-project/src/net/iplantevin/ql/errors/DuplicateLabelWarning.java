package net.iplantevin.ql.errors;

import net.iplantevin.ql.ast.statements.Questionable;

/**
 * @author Ivan
 */
public class DuplicateLabelWarning extends ASTWarning {
    private final Questionable originalQuestionable;
    private final Questionable newQuestionable;

    public DuplicateLabelWarning(String message, Questionable newQuestionable, Questionable originalQuestionable) {
        super(message);
        this.originalQuestionable = originalQuestionable;
        this.newQuestionable = newQuestionable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DuplicateLabelWarning that = (DuplicateLabelWarning) o;

        if (!newQuestionable.equals(that.newQuestionable)) return false;
        if (!originalQuestionable.equals(that.originalQuestionable))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = originalQuestionable.hashCode();
        result = 31 * result + newQuestionable.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DUPLICATE LABEL warning: " + super.toString() + "\n" +
                "Label at location " + newQuestionable.getLabel().getLineInfo() +
                " in question:\n" +
                newQuestionable +
                "already used in question:\n" +
                originalQuestionable +
                "at location " + originalQuestionable.getLineInfo() + "\n";
    }
}
