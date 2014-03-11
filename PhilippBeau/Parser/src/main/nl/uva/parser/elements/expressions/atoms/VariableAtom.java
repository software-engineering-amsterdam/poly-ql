package main.nl.uva.parser.elements.expressions.atoms;

import java.util.ArrayList;
import java.util.List;

import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.errors.VariableNotFoundError;
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
    public List<ValidationError> validate() {
        List<ValidationError> valid = new ArrayList<>();

        if (_parent == null) {
            valid.add(new VariableNotFoundError(_variableName));
            return valid;
        }

        _linkedVariable = _parent.findVariable(_variableName, this);
        if (_linkedVariable == null) {
            valid.add(new VariableNotFoundError(_variableName));
        } else {
            _type = _linkedVariable.getType();
        }

        return valid;
    }

    @Override
    public Type getType() {
        return _type;
    }
}
