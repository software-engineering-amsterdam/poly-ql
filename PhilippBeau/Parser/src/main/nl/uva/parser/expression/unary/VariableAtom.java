package main.nl.uva.parser.expression.unary;

import main.nl.uva.parser.Line;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.error.VariableNotFoundError;
import main.nl.uva.validation.type.Invalid;
import main.nl.uva.validation.type.Value;

public class VariableAtom extends Expression {

    private final String _variableName;

    private Value _linkedValue = new Invalid();

    public VariableAtom(final String variableName, final Line lineInfo) {
        super(lineInfo);
        _variableName = variableName;
    }

    @Override
    public ASTValidation validateAndCalculate(final Scope scope) {
        ASTValidation valid = new ASTValidation();

        if (scope.variableAlreadyDefined(_variableName)) {
            _linkedValue = scope.getVariable(_variableName).getValue();
        } else {
            valid.addError(new VariableNotFoundError(_variableName, getLineInfo()));
        }

        notifyListenersAboutValueChange();
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
