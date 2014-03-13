package main.nl.uva.parser.elements.statements;

import main.nl.uva.parser.elements.ui.UIElement;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

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
    public UIElement getLayout() {
        return null;
    }

    @Override
    public String toString() {
        return _ifStatement.toString() + _elseStatement.toString();
    }
}
