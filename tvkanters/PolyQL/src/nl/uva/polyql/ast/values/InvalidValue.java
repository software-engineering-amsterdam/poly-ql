package nl.uva.polyql.ast.values;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.expressions.modifiers.Modifier;
import nl.uva.polyql.ast.types.Type;
import nl.uva.polyql.view.ValueView;

public class InvalidValue extends Value<Object> {

    public InvalidValue() {
        super(null);
    }

    @Override
    public Type getType() {
        return Type.INVALID;
    }

    @Override
    public ValueView getView(final Question question) {
        return null;
    }

    @Override
    public void setViewValue(final ValueView view) {}

    @Override
    public InvalidValue applyModifier(final Modifier<?> modifier) {
        throw new UnsupportedOperationException();
    }

}
