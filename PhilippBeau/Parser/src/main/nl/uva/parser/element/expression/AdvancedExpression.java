package main.nl.uva.parser.element.expression;

import main.nl.uva.parser.element.error.InvalidTypeError;
import main.nl.uva.parser.element.type.Bool;
import main.nl.uva.parser.element.type.Invalid;
import main.nl.uva.parser.element.type.Money;
import main.nl.uva.parser.element.type.Text;
import main.nl.uva.parser.element.type.Value;
import main.nl.uva.parser.element.validation.ASTValidation;
import main.nl.uva.parser.element.validation.Scope;

public abstract class AdvancedExpression extends Expression {
    protected Value _value = null;

    protected Expression _left;
    protected Expression _right;

    public AdvancedExpression(final Expression left, final Expression right) {
        _left = left;
        _right = right;
    }

    @Override
    public final ASTValidation validate(final Scope scope) {
        ASTValidation valid = _left.validate(scope);
        valid.combine(_right.validate(scope));

        _value = _left.getValue().visit(_right, this);
        notifyListeners();

        if (_value.isInvalid()) {
            valid.addError(new InvalidTypeError(this.toString()));
        }

        return valid;
    }

    @Override
    public Value getValue() {
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