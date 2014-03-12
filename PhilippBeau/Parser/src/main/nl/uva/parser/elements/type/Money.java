package main.nl.uva.parser.elements.type;

import java.awt.Component;

import javax.swing.JTextField;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.atoms.MoneyAtom;

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
        return right.getType().accept(this, expression);
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
    public Component getLayout() {
        return new JTextField();
    }

    @Override
    public boolean visitType(final Value type) {
        return type.acceptType(this);
    }

    @Override
    public boolean acceptType(final Money type) {
        _value = type._value;
        return true;
    }
}
