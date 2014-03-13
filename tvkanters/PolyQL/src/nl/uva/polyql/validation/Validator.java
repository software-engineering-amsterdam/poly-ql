package nl.uva.polyql.validation;

import java.util.HashSet;
import java.util.Set;

import nl.uva.polyql.Log;
import nl.uva.polyql.ast.Form;
import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.Rule;

public class Validator {

    private final Form mForm;
    private final ValidationErrors mErrors = new ValidationErrors();

    public Validator(final Form form) {
        mForm = form;

        validateDuplicates();
        validateTypes();
    }

    private void validateDuplicates() {
        final Set<String> ids = new HashSet<>();
        final Set<String> labels = new HashSet<>();

        for (final Question question : mForm.getQuestions()) {
            final String id = question.getId();
            if (ids.contains(id)) {
                mErrors.add(new DuplicateIdError(question, id));
            } else {
                ids.add(id);
            }

            final String label = question.getLabel();
            if (labels.contains(label)) {
                mErrors.add(new DuplicateLabelWarning(question, label));
            } else {
                labels.add(label);
            }
        }
    }

    private void validateTypes() {
        for (final Rule rule : mForm.getChildRules()) {
            mErrors.merge(rule.validate());
        }
    }

    public boolean isFatal() {
        return mErrors.isFatal();
    }

    public void print() {
        for (final ValidationError error : mErrors.getErrors()) {
            Log.e(error.toString());
        }
    }
}
