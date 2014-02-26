package net.iplantevin.ast.visitors.typechecker;

import net.iplantevin.ast.statements.Questionable;
import net.iplantevin.exceptions.ExceptionCollection;
import net.iplantevin.exceptions.QLDuplicateLabelException;

import java.util.HashMap;

/**
 * Map between label and a questionable (first occurrence).
 *
 * @author Ivan
 */
public class LabelCollection {
    private HashMap<String, Questionable> labels;
    private ExceptionCollection exceptionCollection;

    public LabelCollection(ExceptionCollection exceptionCollection) {
        labels = new HashMap<String, Questionable>();
        this.exceptionCollection = exceptionCollection;
    }

    public void addQuestionable(Questionable questionable) {
        Questionable originalQuestion = isLabelUsed(questionable);
        if (originalQuestion != null) {
            // Label in given question is duplicate from earlier question.
            String message = "this label was already used!";
            QLDuplicateLabelException labelException = new QLDuplicateLabelException(
                    message,
                    questionable,
                    originalQuestion
            );
            exceptionCollection.addException(labelException);
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
