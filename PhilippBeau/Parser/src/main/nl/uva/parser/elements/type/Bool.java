package main.nl.uva.parser.elements.type;

public class Bool extends Type {

    private final String _value;

    public Bool(final String value) {
        super("Boolean");

        _value = value;
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void print() {
        System.out.print("Boolean");
    }
}
