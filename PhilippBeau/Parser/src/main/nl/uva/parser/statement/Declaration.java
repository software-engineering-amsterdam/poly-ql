package main.nl.uva.parser.statement;

import main.nl.uva.parser.expression.Variable;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.element.UIElement;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.error.DuplicatedVariableError;

public class Declaration extends Statement {

    protected final String _function;

    protected final Variable _variable;

    public Declaration(final Variable variable, final String function) {
        super(variable.getLineInfo());
        _function = function;
        _variable = variable;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = _variable.validate(scope);

        if (scope.containsVariable(_variable.getName())) {

            Variable original = scope.getVariableFromScope(_variable.getName());
            valid.addError(new DuplicatedVariableError(original, getLineInfo()));
        } else {

            scope.addToScope(_variable);
        }

        return valid;
    }

    @Override
    public void removeYourselfFromScope(final Scope scope) {
        scope.removeFromScope(_variable);
    }

    @Override
    public UIElement getLayout(final UI parentUI) {
        return new DeclarationUI(_variable, _function, parentUI);
    }

    @Override
    public String toString() {
        return _variable + " " + _function;
    }
}
