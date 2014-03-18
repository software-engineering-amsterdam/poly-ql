package main.nl.uva.parser.element.statement;

import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.UIElement;

public class IfElse extends Block {

    private final IF _ifStatement;
    private final IF _elseStatement;

    public IfElse(final IF ifStatement, final IF elseStatement) {

        _ifStatement = ifStatement;
        _elseStatement = elseStatement;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = _ifStatement.validate(scope);
        valid.combine(_elseStatement.validate(scope));

        return valid;
    }

    @Override
    public UIElement getLayout(final UI parentUI) {
        return null;
    }

    @Override
    public String toString() {
        return _ifStatement.toString() + _elseStatement.toString();
    }
}
