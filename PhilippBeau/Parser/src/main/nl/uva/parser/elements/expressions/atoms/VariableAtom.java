package main.nl.uva.parser.elements.expressions.atoms;

import main.nl.uva.parser.elements.errors.VariableNotFoundError;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.type.Invalid;
import main.nl.uva.parser.elements.type.Value;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

public class VariableAtom extends Expression {

    private final String _variableName;

    private Value _linkedValue = new Invalid();

    public VariableAtom(final String variableName) {
        _variableName = variableName;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = new ASTValidation();

        if (scope.containsVariable(_variableName)) {
            _linkedValue = scope.getVariableFromScope(_variableName).getValue();
        } else {
            valid.addError(new VariableNotFoundError(_variableName));
        }

        return valid;
    }

    @Override
    public Value getValue() {
        return _linkedValue;
    }

    @Override
    public String toString() {
        return _variableName;
    }
}
