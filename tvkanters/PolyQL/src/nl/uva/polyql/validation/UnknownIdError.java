package nl.uva.polyql.validation;

import nl.uva.polyql.model.expressions.QuestionAtom;

public class UnknownIdError extends ValidationError {

    private final String mId;

    public UnknownIdError(final QuestionAtom questionAtom) {
        super(questionAtom);
        mId = questionAtom.getId();
    }

    @Override
    public String getLabel() {
        return "Unknown question ID: " + mId;
    }
}
