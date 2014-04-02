package main.nl.uva.parser.statement;

import main.nl.uva.parser.expression.Variable;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.element.UIElement;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.error.DuplicatedVariableError;
import main.nl.uva.validation.warning.DuplicateLabelWarning;

public class Declaration extends Statement {

    protected final String _label;

    protected final Variable _variable;

    public Declaration(final Variable variable, final String function) {
        super(variable.getLineInfo());
        _label = function;
        _variable = variable;
    }

    @Override
    public ASTValidation validateAndCalculate(final Scope scope) {
        ASTValidation valid = _variable.validateAndCalculate(scope);

        if (scope.labelAlreadyDefined(_label)) {
            valid.addWarning(new DuplicateLabelWarning(_label, scope.getFirstDeclarationForLabel(_label), getLineInfo()));
        } else {
            scope.defineLabel(_label, getLineInfo());
        }

        if (scope.variableAlreadyDefined(_variable.getName())) {

            Variable original = scope.getVariable(_variable.getName());
            valid.addError(new DuplicatedVariableError(original, getLineInfo()));
        } else {

            scope.defineVariable(_variable);
        }

        return valid;
    }

    @Override
    public void removeYourselfFromScope(final Scope scope) {
        scope.removeVariable(_variable);
        scope.removeLabel(_label);
    }

    @Override
    public UIElement getLayout(final UI parentUI) {
        return new DeclarationUI(_variable, _label, parentUI);
    }

    @Override
    public String toString() {
        return _variable + " " + _label;
    }
}
