package main.nl.uva.validation.type;

import main.nl.uva.parser.expression.AdvancedExpression;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.types.TextUI;
import main.nl.uva.ui.types.ValueUI;

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
        return new TextUI(parent, this);
    }

    @Override
    public boolean applyValueTo(final Value type) {
        return type.acceptType(this);
    }

    @Override
    public boolean acceptType(final Text type) {
        _value = type._value;
        return true;
    }
}
