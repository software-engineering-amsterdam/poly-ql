package main.nl.uva.validation.type;

import main.nl.uva.parser.expression.BinaryExpression;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.types.BooleanUI;
import main.nl.uva.ui.types.ValueUI;

public class Bool extends Value {

    private boolean _value;

    public Bool() {
        this(false);
    }

    public Bool(final boolean value) {
        super(Value.Type.BOOLEAN);
        _value = value;
    }

    public void setValue(final boolean value) {
        _value = value;
    }

    public boolean getValue() {
        return _value;
    }

    @Override
    public Value calculateValueWith(final Expression right, final BinaryExpression expression) {
        return right.getValue().calculateValueWith(this, expression);
    }

    @Override
    public Value calculateValueWith(final Bool left, final BinaryExpression expression) {
        return expression.calculateValue(left, this);
    }

    @Override
    public Value calculateValueWith(final Money left, final BinaryExpression expression) {
        return expression.calculateValue(left, this);
    }

    @Override
    public Value calculateValueWith(final Text left, final BinaryExpression expression) {
        return expression.calculateValue(left, this);
    }

    @Override
    public ValueUI getLayout(final DeclarationUI parent) {
        return new BooleanUI(parent, this);
    }

    @Override
    public boolean applyValueTo(final Value type) {
        return type.acceptType(this);
    }

    @Override
    public boolean acceptType(final Bool type) {
        _value = type._value;
        return true;
    }

    @Override
    public String toString() {
        return "Bool: " + _value;
    }
}
