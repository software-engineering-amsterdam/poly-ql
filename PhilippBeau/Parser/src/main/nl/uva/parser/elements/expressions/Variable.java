package main.nl.uva.parser.elements.expressions;

import main.nl.uva.parser.elements.errors.InvalidTypeError;
import main.nl.uva.parser.elements.type.Value;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

public class Variable extends Expression {

    private final Value _value;

    private final String _name;

    private Expression _expression;

    public Variable(final Value type, final String name, final Expression expression) {
        _value = type;
        _name = name;
        _expression = expression;
    }

    public Variable(final Value type, final String name) {
        this(type, name, type.getAtom());
    }

    public boolean setExpression(final Expression newExpression) {
        if (!newExpression.getValue().isOfSameType(_value)) {
            // Type is not acceptable
            return false;
        }

        _expression = newExpression;
        _expression.getValue().applyValueTo(_value);

        return true;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = _expression.validate(scope);

        if (valid.hasErrors() && !_value.applyValueTo(_expression.getValue())) {
            valid.addError(new InvalidTypeError(this.toString()));
        }

        return valid;
    }

    public String getName() {
        return _name;
    }

    @Override
    public Value getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return "( " + _value.toString() + " " + _name + " " + _value + " )";
    }
}
