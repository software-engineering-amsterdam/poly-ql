package main.nl.uva.parser.expression;

import main.nl.uva.parser.Line;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.error.InvalidTypeError;
import main.nl.uva.validation.type.Bool;
import main.nl.uva.validation.type.Invalid;
import main.nl.uva.validation.type.Money;
import main.nl.uva.validation.type.Text;
import main.nl.uva.validation.type.Value;

public abstract class BinaryExpression extends Expression {
    protected Value _value = null;

    protected Expression _left;
    protected Expression _right;

    public BinaryExpression(final Expression left, final Expression right, final Line lineInfo) {
        super(lineInfo);
        _left = left;
        _right = right;
    }

    @Override
    public final ASTValidation validateAndCalculate(final Scope scope) {
        ASTValidation valid = _left.validateAndCalculate(scope);
        valid.combine(_right.validateAndCalculate(scope));

        _value = _left.getValue().calculateValueWith(_right, this);
        notifyListenersAboutValueChange();

        if (_value.isInvalid()) {
            valid.addError(new InvalidTypeError(this.toString(), getLineInfo()));
        }

        return valid;
    }

    @Override
    public Value getValue() {
        return _value;
    }

    public Value calculateValue(final Bool left, final Bool right) {
        return new Invalid();
    }

    public Value calculateValue(final Money left, final Money right) {
        return new Invalid();
    }

    public Value calculateValue(final Text left, final Text right) {
        return new Invalid();
    }

    public Value calculateValue(final Bool left, final Money right) {
        return new Invalid();
    }

    public Value calculateValue(final Bool left, final Text right) {
        return new Invalid();
    }

    public Value calculateValue(final Money left, final Bool right) {
        return new Invalid();
    }

    public Value calculateValue(final Money left, final Text right) {
        return new Invalid();
    }

    public Value calculateValue(final Text left, final Bool right) {
        return new Invalid();
    }

    public Value calculateValue(final Text left, final Money right) {
        return new Invalid();
    }
}