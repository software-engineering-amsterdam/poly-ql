package main.nl.uva.parser.elements.statements;

import java.util.List;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.Variable;

public class IFStatement extends BlockStatement {

    protected final List<Statement> _children;

    private final Expression _expression;

    public IFStatement(final Expression expression, final List<Statement> children) {

        _expression = expression;
        _children = children;

        _expression.setParent(this);
        setParentForChildren(_children);
    }

    @Override
    public Variable findVariable(final String variableName, final Statement scopeEnd) {
        if (scopeEnd != _expression) {
            Variable result = findVariableInChildren(_children, variableName, scopeEnd);
            if (result != null) {
                return result;
            }
        }

        return _parent.findVariable(variableName, this);
    }

    @Override
    public boolean validate() {
        boolean expression = _expression.validate();
        return validateStatements(_children) && expression;
    }

    @Override
    public String toString() {
        String erg = "if ( " + _expression + " ) \n{ \n";
        for (Statement child : _children) {
            erg += child + "\n";
        }

        return erg + "} \n";
    }
}
