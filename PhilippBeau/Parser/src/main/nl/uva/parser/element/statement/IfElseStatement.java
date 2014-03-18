package main.nl.uva.parser.element.statement;

import main.nl.uva.parser.element.ui.UIElement;
import main.nl.uva.parser.element.validation.ASTValidation;
import main.nl.uva.parser.element.validation.Scope;
import main.nl.uva.ui.UI;

public class IfElseStatement extends BlockStatement {

    private final IFStatement _ifStatement;
    private final IFStatement _elseStatement;

    public IfElseStatement(final IFStatement ifStatement, final IFStatement elseStatement) {

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
