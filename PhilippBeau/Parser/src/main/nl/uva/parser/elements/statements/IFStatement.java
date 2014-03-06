package main.nl.uva.parser.elements.statements;

import java.util.List;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.Variable;

public class IFStatement extends Statement {

    protected final List<Statement> _children;

    private final Expression _expression;

    public IFStatement(final Expression expression, final List<Statement> children) {

        _expression = expression;
        _children = children;
    }

    @Override
    public String toString() {
        String erg = "if ( " + _expression + " ) \n{ \n";
        for (Statement child : _children) {
            erg += child + "\n";
        }

        return erg + "} \n";
    }

    @Override
    public Variable findVariable(final String variableName) {
        return findVariableInChildren(_children, variableName);
    }
}
