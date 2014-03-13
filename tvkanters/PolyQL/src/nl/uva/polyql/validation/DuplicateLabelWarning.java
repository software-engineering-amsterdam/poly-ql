package nl.uva.polyql.validation;

import nl.uva.polyql.ast.Question;

public class DuplicateLabelWarning extends ValidationError {

    private final String mLabel;

    public DuplicateLabelWarning(final Question question, final String label) {
        super(question);
        mLabel = question.getLabel();
    }

    @Override
    public String getLabel() {
        return "Duplicate question label: " + mLabel;
    }

    @Override
    public boolean isFatal() {
        return false;
    }
}
