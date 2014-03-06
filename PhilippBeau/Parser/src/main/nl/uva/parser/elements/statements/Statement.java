package main.nl.uva.parser.elements.statements;

public abstract class Statement {

    protected Statement _parent;

    public void setParent(final Statement parent) {
        _parent = parent;
    }

    public boolean validate() {
        return true;
    }
}
