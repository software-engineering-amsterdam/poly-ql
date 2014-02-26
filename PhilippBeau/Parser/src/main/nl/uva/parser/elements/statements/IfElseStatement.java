package main.nl.uva.parser.elements.statements;

public class IfElseStatement extends Statement {

    public IfElseStatement(final String id, final Statement parent) {
        super(id, parent);
    }

    @Override
    public String toString() {
        return "IfElseStatement ";
    }

    @Override
    protected boolean validateImpl() {

        boolean valid = _parent.validates(this);

        if (!valid) {
            System.err.println(this + "Is very very wrong");
        }

        return valid;
    }
}
