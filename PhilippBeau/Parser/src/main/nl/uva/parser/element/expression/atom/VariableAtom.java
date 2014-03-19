package main.nl.uva.parser.element.expression.atom;

import main.nl.uva.parser.element.Line;
import main.nl.uva.parser.element.error.VariableNotFoundError;
import main.nl.uva.parser.element.expression.Expression;
import main.nl.uva.parser.element.type.Invalid;
import main.nl.uva.parser.element.type.Value;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;

public class VariableAtom extends Expression {

    private final String _variableName;

    private Value _linkedValue = new Invalid();

    public VariableAtom(final String variableName, final Line lineInfo) {
        super(lineInfo);
        _variableName = variableName;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = new ASTValidation();

        if (scope.containsVariable(_variableName)) {
            _linkedValue = scope.getVariableFromScope(_variableName).getValue();
        } else {
            valid.addError(new VariableNotFoundError(_variableName, getLineInfo()));
        }

        notifyListeners();
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
