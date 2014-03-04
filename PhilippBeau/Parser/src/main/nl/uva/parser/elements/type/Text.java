package main.nl.uva.parser.elements.type;

public class Text extends Type {

    public Text() {
        super("Text");
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void print() {
        System.out.print("Text");
    }
}
