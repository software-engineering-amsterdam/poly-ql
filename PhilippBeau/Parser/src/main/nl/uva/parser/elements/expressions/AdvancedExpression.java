package main.nl.uva.parser.elements.expressions;

import java.util.List;

import main.nl.uva.parser.elements.errors.InvalidTypeError;
import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Invalid;
import main.nl.uva.parser.elements.type.Money;
import main.nl.uva.parser.elements.type.Text;
import main.nl.uva.parser.elements.type.Type;

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

        _type = getType();
        if (_type instanceof Invalid) {
            left.add(new InvalidTypeError(this.toString()));
        }

        return left;
    }

    @Override
    public Type getType() {
        if (_type != null) {
            return _type;
        }

        _type = _left.getType().visit(_right, this);
        return _type;
    }

    public Type calculateType(final Bool left, final Bool right) {
        return new Bool();
    }

    public Type calculateType(final Money left, final Money right) {
        return new Money();
    }

    public Type calculateType(final Text left, final Text right) {
        return new Text();
    }

    public final Type calculateType(final Bool left, final Money right) {
        return new Invalid();
    }

    public final Type calculateType(final Bool left, final Text right) {
        return new Invalid();
    }

    public final Type calculateType(final Money left, final Bool right) {
        return new Invalid();
    }

    public final Type calculateType(final Money left, final Text right) {
        return new Invalid();
    }

    public final Type calculateType(final Text left, final Bool right) {
        return new Invalid();
    }

    public final Type calculateType(final Text left, final Money right) {
        return new Invalid();
    }
}