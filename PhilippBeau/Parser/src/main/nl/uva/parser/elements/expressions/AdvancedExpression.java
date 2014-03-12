package main.nl.uva.parser.elements.expressions;

import java.util.List;

import main.nl.uva.parser.elements.errors.InvalidTypeError;
import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Invalid;
import main.nl.uva.parser.elements.type.Money;
import main.nl.uva.parser.elements.type.Text;
import main.nl.uva.parser.elements.type.Value;

public abstract class AdvancedExpression extends Expression {

    protected Expression _left;
    protected Expression _right;

    public AdvancedExpression(final Expression left, final Expression right) {

        _left = left;
        _right = right;

        _left.setParent(this);
        _right.setParent(this);
    }

    @Override
    public final List<ValidationError> validate() {
        List<ValidationError> left = _left.validate();
        List<ValidationError> right = _right.validate();

        if (!left.isEmpty() || !right.isEmpty()) {
            left.addAll(right);
            return left;
        }

        _value = _left.getType().visit(_right, this);

        if (_value.isInvalid()) {
            left.add(new InvalidTypeError(this.toString()));
        }

        return left;
    }

    @Override
    public Value getType() {
        return _value;
    }

    public Value calculateType(final Bool left, final Bool right) {
        return new Invalid();
    }

    public Value calculateType(final Money left, final Money right) {
        return new Invalid();
    }

    public Value calculateType(final Text left, final Text right) {
        return new Invalid();
    }

    public final Value calculateType(final Bool left, final Money right) {
        return new Invalid();
    }

    public final Value calculateType(final Bool left, final Text right) {
        return new Invalid();
    }

    public final Value calculateType(final Money left, final Bool right) {
        return new Invalid();
    }

    public final Value calculateType(final Money left, final Text right) {
        return new Invalid();
    }

    public final Value calculateType(final Text left, final Bool right) {
        return new Invalid();
    }

    public final Value calculateType(final Text left, final Money right) {
        return new Invalid();
    }
}