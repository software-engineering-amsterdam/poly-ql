package nl.uva.polyql.ast.values;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.view.QuestionView;

public class InvalidValue extends Value<Object> {

    public InvalidValue() {
        super(null);
    }

    @Override
    public Type getType() {
        return Type.INVALID;
    }

    @Override
    public QuestionView getView(final Question question) {
        return null;
    }

    @Override
    public void setViewValue(final QuestionView view) {}

}
