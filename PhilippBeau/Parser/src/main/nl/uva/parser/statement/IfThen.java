package main.nl.uva.parser.statement;

import java.util.List;

import main.nl.uva.parser.Line;
import main.nl.uva.parser.expression.Expression;
import main.nl.uva.ui.UI;
import main.nl.uva.ui.element.IfThenUI;
import main.nl.uva.ui.element.UIElement;
import main.nl.uva.validation.ASTValidation;
import main.nl.uva.validation.Scope;
import main.nl.uva.validation.error.InvalidTypeError;
import main.nl.uva.validation.type.Value;

public class IfThen extends Block {

    protected final List<Statement> _ifStatements;

    protected final Expression _expression;

    public IfThen(final Expression expression, final List<Statement> ifStatements, final Line lineInfo) {
        super(lineInfo);
        _expression = expression;
        _ifStatements = ifStatements;
    }

    @Override
    public ASTValidation validateAndCalculate(final Scope scope) {
        ASTValidation valid = _expression.validateAndCalculate(scope);

        if (!(_expression.getValue().isTypeOf(Value.Type.BOOLEAN))) {
            valid.addError(new InvalidTypeError(this.toString(), getLineInfo()));
        }

        valid = validateChildren(valid, _ifStatements, scope);
        removeChildrenFromScope(_ifStatements, scope);

        return valid;
    }

    @Override
    public String toString() {
        return "if ( " + _expression + " )";
    }

    @Override
    public UIElement getLayout(final UI parentUI) {
        return new IfThenUI(_expression, _ifStatements, parentUI);
    }
}
