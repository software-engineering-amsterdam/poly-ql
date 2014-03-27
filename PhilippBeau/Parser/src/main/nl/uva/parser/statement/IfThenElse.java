package main.nl.uva.parser.statement;

import java.util.List;

import main.nl.uva.parser.Line;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.IfThenElseUI;
import main.nl.uva.ui.element.UIElement;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;

public class IfThenElse extends IfThen {

    private final List<Statement> _elseStatements;

    public IfThenElse(final Expression expression, final List<Statement> ifStatements, final List<Statement> elseStatements,
            final Line lineInfo) {
        super(expression, ifStatements, lineInfo);

        _elseStatements = elseStatements;
    }

    @Override
    public ASTValidation validateAndCalculate(final Scope scope) {
        ASTValidation valid = super.validateAndCalculate(scope);

        valid = validateChildren(valid, _elseStatements, scope);
        removeChildrenFromScope(_elseStatements, scope);

        return valid;
    }

    @Override
    public UIElement getLayout(final UI parentUI) {
        return new IfThenElseUI(_expression, _ifStatements, _elseStatements, parentUI);
    }

    @Override
    public String toString() {
        return "else";
    }
}
