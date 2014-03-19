package nl.uva.polyql.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.uva.polyql.ast.Form;
import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.Rule;
import nl.uva.polyql.utils.Log;

public class Validator {

    private final Form mForm;
    private final ValidationErrors mErrors = new ValidationErrors();

    public static Validator validate(final Form form) {
        final Validator validator = new Validator(form);
        validator.validateDuplicates();
        validator.validateTypes();
        return validator;
    }

    private Validator(final Form form) {
        mForm = form;
    }

    private void validateDuplicates() {
        final Set<String> ids = new HashSet<>();
        final Set<String> labels = new HashSet<>();

        for (final Question question : mForm.getQuestionsRecursively()) {
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
        for (final Rule rule : mForm.getRules()) {
            mErrors.merge(rule.validate());
        }
    }

    public List<ValidationError> getErrors() {
        return mErrors.getErrors();
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
