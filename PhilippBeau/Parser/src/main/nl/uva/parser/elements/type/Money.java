package main.nl.uva.parser.elements.type;

public class Money extends Type {

    private double _value = 0.0d;

    public Money() {
        super(Type.Of.MONEY);
    }

    public Money(final String value) {
        super(Type.Of.MONEY);

        _value = Double.parseDouble(value);
    }

}
