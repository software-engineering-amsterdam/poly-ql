package main.nl.uva.parser.element.statement;

import java.util.List;

import main.nl.uva.parser.element.error.InvalidTypeError;
import main.nl.uva.parser.element.expression.Expression;
import main.nl.uva.parser.element.type.Value;
import main.nl.uva.parser.element.validation.ASTValidation;
import main.nl.uva.parser.element.validation.Scope;
import main.nl.uva.parser.ui.IfUIElement;
import main.nl.uva.parser.ui.UIElement;
import main.nl.uva.ui.UI;

public class IFStatement extends BlockStatement {

    protected final List<Statement> _children;

    private final Expression _expression;

    public IFStatement(final Expression expression, final List<Statement> children) {
        _expression = expression;
        _children = children;
    }

    @Override
    public ASTValidation validate(final Scope scope) {
        ASTValidation valid = _expression.validate(scope);

        if (!(_expression.getValue().isTypeOf(Value.Type.BOOLEAN))) {
            valid.addError(new InvalidTypeError(this.toString()));
        }

        valid = validateChildren(valid, _children, scope);
        removeChildrenFromScope(_children, scope);

        return valid;
    }

    @Override
    public String toString() {
        return "if ( " + _expression + " ) \n";
    }

    public String printFull() {
        String erg = "if ( " + _expression + " ) \n{ \n";
        for (Statement child : _children) {
            erg += child + "\n";
        }

        return erg + "} \n";
    }

    @Override
    public UIElement getLayout(final UI parentUI) {
        return new IfUIElement(_expression, _children, parentUI);
    }
}
