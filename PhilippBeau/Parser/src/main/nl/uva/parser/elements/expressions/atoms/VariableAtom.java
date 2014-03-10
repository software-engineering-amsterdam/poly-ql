package main.nl.uva.parser.elements.expressions.atoms;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.Variable;
import main.nl.uva.parser.elements.type.Type;

public class VariableAtom extends Expression {

    private final String _variableName;

    private Variable _linkedVariable = null;

    public VariableAtom(final String variableName) {
        _variableName = variableName;
    }

    public void setLinkedVariable(final Variable variable) {
        _linkedVariable = variable;
    }

    @Override
    public String toString() {
        return _variableName;
    }

    @Override
    public boolean validate() {
        if (_parent == null) {
            return false;
        }

        _linkedVariable = _parent.findVariable(_variableName, this);
        if (_linkedVariable == null) {
            System.err.println("Error: " + _variableName + " not found");
        } else {
            _type = _linkedVariable.getType();
        }

        return _linkedVariable != null;
    }

    @Override
    public Type getType() {
        return _type;
    }
}
