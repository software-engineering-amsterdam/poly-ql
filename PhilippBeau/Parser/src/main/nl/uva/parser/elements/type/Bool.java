package main.nl.uva.parser.elements.type;

import java.awt.Component;

import javax.swing.JCheckBox;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.atoms.BoolAtom;

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
    public Expression getAtom() {
        return new BoolAtom();
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
        return new JCheckBox();
    }

    @Override
    public boolean visitType(final Value type) {
        return type.acceptType(this);
    }

    @Override
    public boolean acceptType(final Bool type) {
        _value = type._value;
        return true;
    }
}
