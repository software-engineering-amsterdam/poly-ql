package main.nl.uva.parser.elements.type;

public class Text extends Type {

    private String _value = "";

    public Text() {
        super(Type.Of.TEXT);
    }

    public Text(final String value) {
        super(Type.Of.TEXT);

        _value = value;
    }
}
