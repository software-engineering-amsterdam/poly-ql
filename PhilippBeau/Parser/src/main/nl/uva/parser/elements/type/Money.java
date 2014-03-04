package main.nl.uva.parser.elements.type;

public class Money extends Type {

    private final String _amount;

    public Money(final String amount) {
        super("Money");

        _amount = amount;
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void print() {
        System.out.print(_amount);
    }
}
