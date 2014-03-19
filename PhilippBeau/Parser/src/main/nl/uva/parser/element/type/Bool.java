package main.nl.uva.parser.element.type;

import main.nl.uva.parser.element.expression.AdvancedExpression;
import main.nl.uva.parser.element.expression.Expression;
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
