package main.nl.uva.parser.elements.statements;

import java.util.List;

import main.nl.uva.parser.elements.expressions.Expression;

public class IfElseStatement extends Statement {

    private final List<Statement> _ifChildren;
    private final List<Statement> _elseChildren;

    public IfElseStatement(final Expression expression, final List<Statement> ifChildren,
            final List<Statement> elseChildren) {
        super("");

        _ifChildren = ifChildren;
        _elseChildren = elseChildren;
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

    @Override
    public void print() {
        System.out.println(_id + " if " + _ifChildren.size());

        for (Statement st : _ifChildren) {
            st.print();
        }

        System.out.println(" else " + _elseChildren.size());

        for (Statement st : _elseChildren) {
            st.print();
        }
    }
}
