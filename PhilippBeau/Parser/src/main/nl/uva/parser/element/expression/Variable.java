package main.nl.uva.parser.element.expression;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.element.error.InvalidTypeError;
import main.nl.uva.parser.element.type.Value;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;

public class Variable extends Expression implements ExpressionChangeListener {

    private final Value.Type _value;

    private final String _name;

    private Expression _expression;

    private final List<ExpressionChangeListener> _listener = new ArrayList<>();

    public Variable(final Value.Type type, final String name, final Expression expression) {
        _value = type;
        _name = name;
        _expression = expression;

        _expression.registerListener(this);
    }

    public Variable(final Value.Type type, final String name) {
        this(type, name, type.getAtom());
    }

    @Override
    public boolean registerListener(final ExpressionChangeListener listener) {
        return _listener.add(listener);
    }

    public boolean setExpression(final Expression newExpression) {
        if (!newExpression.getValue().isTypeOf(_value)) {
            // Type is not acceptable
            return false;
        }

        _expression = newExpression;
        _expression.registerListener(this);

        return true;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = _expression.validate(scope);

        if (!_expression.getValue().isTypeOf(_value)) {
            valid.addError(new InvalidTypeError(this.toString()));
        }

        return valid;
    }

    public String getName() {
        return _name;
    }

    @Override
    public Value getValue() {
        return _expression.getValue();
    }

    @Override
    public String toString() {
        return "( " + _value.toString() + " " + _name + " " + _value + " )";
    }

    @Override
    public void onChange() {

        for (ExpressionChangeListener listener : _listener) {
            listener.onChange();
        }
    }
}
