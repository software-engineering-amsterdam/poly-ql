package main.nl.uva.parser.elements.type;

import main.nl.uva.parser.elements.expressions.Expression;

public class VariableContainer extends Expression {

    private final String _variableName;

    private Variable _linkedVariable = null;

    public VariableContainer(final String variableName) {
        super("VariableContainer");

        _variableName = variableName;
    }

    public void setLinkedVariable(final Variable variable) {
        _linkedVariable = variable;
    }

    @Override
    public Type isOfType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected boolean validateImpl() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub

    }

}
