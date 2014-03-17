package main.nl.uva.parser.elements.type;

import java.awt.Component;

import javax.swing.JTextField;

import main.nl.uva.parser.elements.expressions.AdvancedExpression;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.atoms.TextAtom;

public class Text extends Value {

    private String _value;

    public Text() {
        this("");
    }

    public Text(final String value) {
        super(Value.Type.TEXT);
        _value = value;
    }

    public void setValue(final String value) {
        _value = value;
    }

    public String getValue() {
        return _value;
    }

    @Override
    public Expression getAtom() {
        return new TextAtom();
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
    public boolean acceptType(final Text type) {
        _value = type._value;
        return true;
    }
}