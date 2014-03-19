package main.nl.uva.parser.element.expression.atom;

import main.nl.uva.parser.element.Line;
import main.nl.uva.parser.element.type.Money;
import main.nl.uva.parser.element.type.Value;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;

public class MoneyAtom extends AtomExpression {

    public MoneyAtom() {
        this("0.0", Line.NO_LINE_NUMBER);
    }

    public MoneyAtom(final Line lineInfo) {
        this("0.0", lineInfo);
    }

    public MoneyAtom(final String value, final Line lineInfo) {
        super(lineInfo);
        _value = new Money(Double.parseDouble(value));
    }

    public MoneyAtom(final Money value, final Line lineInfo) {
        super(lineInfo);
        _value = value;
    }

    public MoneyAtom(final Money money) {
        this(money, Line.NO_LINE_NUMBER);
    }

    public MoneyAtom(final String value) {
        this(value, Line.NO_LINE_NUMBER);
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
