package main.nl.uva.parser.element.type;

import main.nl.uva.parser.element.expression.AdvancedExpression;
import main.nl.uva.parser.element.expression.Expression;
import main.nl.uva.parser.element.expression.atom.MoneyAtom;
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
    public Expression getAtom() {
        return new MoneyAtom();
    }

    @Override
    public Value visit(final Expression right, final AdvancedExpression expression) {
        return right.getValue().accept(this, expression);
    }

    @Override
    public Value accept(final Bool left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }

    @Override
    public Value accept(final Money left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }

    @Override
    public Value accept(final Text left, final AdvancedExpression expression) {
        return expression.calculateType(left, this);
    }

    @Override
    public ValueUI getLayout(final DeclarationUI parent) {
        return new MoneyUI(parent);
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
