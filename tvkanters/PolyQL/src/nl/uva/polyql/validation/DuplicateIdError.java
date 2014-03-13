package nl.uva.polyql.validation;

import nl.uva.polyql.ast.Question;

public class DuplicateIdError extends ValidationError {

    private final String mId;

    public DuplicateIdError(final Question question, final String id) {
        super(question);
        mId = question.getId();
    }

    @Override
    public String getLabel() {
        return "Duplicate question ID: " + mId;
    }
}
