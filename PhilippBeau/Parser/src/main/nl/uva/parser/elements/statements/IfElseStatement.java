package main.nl.uva.parser.elements.statements;

import java.util.List;

import main.nl.uva.parser.elements.expressions.Expression;

public class IfElseStatement extends Statement {

    private final List<Statement> _ifChildren;
    private final List<Statement> _elseChildren;
    private final Expression _expression;

    public IfElseStatement(final Expression expression, final List<Statement> ifChildren,
            final List<Statement> elseChildren) {

        _ifChildren = ifChildren;
        _elseChildren = elseChildren;
        _expression = expression;
    }

    @Override
    public String toString() {
        String erg = "if ( " + _expression + " ) { \n";
        for (Statement child : _ifChildren) {
            erg += child + "\n";
        }

        erg += "} else {\n";
        for (Statement child : _elseChildren) {
            erg += child + "\n";
        }

        return erg + "} \n";
    }
}
