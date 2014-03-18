package main.nl.uva.parser.element.statement;

import main.nl.uva.parser.element.expression.Variable;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.ui.element.UIElement;

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

        scope.addToScope(_variable);
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
