package main.nl.uva.validation.type;

import main.nl.uva.parser.expression.AdvancedExpression;
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
    public Value applyTo(final Expression right, final AdvancedExpression expression) {
        return right.getValue().applyTo(this, expression);
    }

    @Override
    public Value applyTo(final Bool left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }

    @Override
    public Value applyTo(final Money left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }

    @Override
    public Value applyTo(final Text left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
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
