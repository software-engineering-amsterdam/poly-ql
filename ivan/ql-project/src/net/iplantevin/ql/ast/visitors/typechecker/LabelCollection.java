package net.iplantevin.ql.ast.visitors.typechecker;

import net.iplantevin.ql.ast.statements.Questionable;
import net.iplantevin.ql.errors.DuplicateLabelError;
import net.iplantevin.ql.errors.ErrorCollection;

import java.util.HashMap;

/**
 * Map between label and a questionable (first occurrence).
 *
 * @author Ivan
 */
public class LabelCollection {
    private final HashMap<String, Questionable> labels;
    private final ErrorCollection errorCollection;

    public LabelCollection(ErrorCollection errorCollection) {
        labels = new HashMap<String, Questionable>();
        this.errorCollection = errorCollection;
    }

    public void addQuestionable(Questionable questionable) {
        Questionable originalQuestion = isLabelUsed(questionable);
        if (originalQuestion != null) {
            // Label in given question is duplicate from earlier question.
            String message = "this label was already used!";
            DuplicateLabelError labelException = new DuplicateLabelError(
                    message,
                    questionable,
                    originalQuestion
            );
            errorCollection.addException(labelException);
        } else {
            labels.put(questionable.getLabel().getText(), questionable);
        }
    }

    private Questionable isLabelUsed(Questionable questionable) {
        if (labels.containsKey(questionable.getLabel().getText())) {
            return labels.get(questionable.getLabel().getText());
        } else {
            return null;
        }
    }
}
