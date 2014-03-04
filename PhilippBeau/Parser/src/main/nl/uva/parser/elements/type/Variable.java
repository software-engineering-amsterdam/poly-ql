package main.nl.uva.parser.elements.type;

public class Variable extends Type {

    public static enum Types {
        BOOL,
        TEXT,
        MONEY;
    }

    private final String _name;

    public Variable(final String name) {
        super("Variable");

        _name = name;
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void print() {
        System.out.print(_name);
    }
}
