package main.nl.uva.parser.expression.unary;

import main.nl.uva.parser.Line;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.type.Money;
import main.nl.uva.validation.type.Value;

public class MoneyAtom extends UnaryExpression {

    public MoneyAtom() {
        this(new Money(0.0d), Line.NO_LINE_NUMBER);
    }

    public MoneyAtom(final Money value, final Line lineInfo) {
        super(lineInfo);
        _value = value;
    }

    public MoneyAtom(final Money money) {
        this(money, Line.NO_LINE_NUMBER);
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        return new ASTValidation();
    }

    @Override
    public Value getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return "Money: " + _value;
    }
}
