package main.nl.uva.parser.elements.expressions;

import java.util.List;

import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.type.Type;

public class NotExpression extends Expression {

    private final Expression _expression;

    public NotExpression(final Expression expression) {
        expression.setParent(this);

        _expression = expression;
    }

    @Override
    public Type getType() {
        return _expression.getType();
    }

    @Override
    public List<ValidationError> validate() {
        return _expression.validate();
    }

}
