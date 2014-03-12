package main.nl.uva.parser.elements.expressions;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.elements.errors.InvalidTypeError;
import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.atoms.VariableAtom;
import main.nl.uva.parser.elements.type.Value;

public class Variable extends Expression {

    private final String _name;

    private Expression _expression;

    private final List<VariableAtom> _linkedVariables = new ArrayList<>();

    public Variable(final Value type, final String name, final Expression expression) {
        _value = type;
        _name = name;
        _expression = expression;

        _expression.setParent(this);
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
        _expression.setParent(this);

        for (VariableAtom linkedVariable : _linkedVariables) {
            linkedVariable.recalculateValue();
        }

        return true;
    }

    @Override
    public String toString() {
        return "( " + _value.toString() + " " + _name + " " + _value + " )";
    }

    @Override
    public List<ValidationError> validate() {
        List<ValidationError> valError = _expression.validate();

        if (valError.isEmpty() && !_value.applyValueTo(_expression.getValue())) {
            valError.add(new InvalidTypeError(this.toString()));
        }

        return valError;
    }

    public String getName() {
        return _name;
    }

    @Override
    public Value getValue() {
        return _value;
    }

    public boolean setLinkedVariable(final VariableAtom linkedVariable) {
        return _linkedVariables.add(linkedVariable);
    }

    @Override
    protected void recalculateValueImpl() {}
}
