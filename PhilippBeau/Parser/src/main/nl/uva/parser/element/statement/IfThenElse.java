package main.nl.uva.parser.element.statement;

import java.util.List;

import main.nl.uva.parser.element.Line;
import main.nl.uva.parser.element.expression.Expression;
import main.nl.uva.parser.validation.ASTValidation;
import main.nl.uva.parser.validation.Scope;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.UIElement;

public class IfThenElse extends IfThen {

    private final List<Statement> _elseStatements;

    public IfThenElse(final Expression expression, final List<Statement> ifStatements, final List<Statement> elseStatements,
            final Line lineInfo) {
        super(expression, ifStatements, lineInfo);

        _elseStatements = elseStatements;
    }

    public IfThenElse(final Expression expression, final List<Statement> ifStatements, final List<Statement> elseStatements) {
        super(expression, ifStatements, Line.NO_LINE_NUMBER);

        _elseStatements = elseStatements;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = super.validate(scope);

        valid = validateChildren(valid, _elseStatements, scope);
        removeChildrenFromScope(_elseStatements, scope);

        return valid;
    }

    @Override
    public UIElement getLayout(final UI parentUI) {
        return null;
    }

    @Override
    public String toString() {
        return "else";
    }
}
