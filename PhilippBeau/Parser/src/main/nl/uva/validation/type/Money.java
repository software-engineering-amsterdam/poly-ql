package main.nl.uva.validation.type;

import main.nl.uva.parser.expression.BinaryExpression;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.types.MoneyUI;
import main.nl.uva.ui.types.ValueUI;

public class Money extends Value {

    private double _value;

    public Money() {
        this(0.0d);
    }

    public Money(final double value) {
        super(Value.Type.MONEY);
        _value = value;
    }

    public void setValue(final double value) {
        _value = value;
    }

    public double getValue() {
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
        return new MoneyUI(parent, this);
    }

    @Override
    public boolean applyValueTo(final Value type) {
        return type.acceptType(this);
    }

    @Override
    public boolean acceptType(final Money type) {
        _value = type._value;
        return true;
    }

    @Override
    public String toString() {
        return "Money: " + _value;
    }
}
