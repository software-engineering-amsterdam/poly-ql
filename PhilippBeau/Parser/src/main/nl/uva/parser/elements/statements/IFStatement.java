package main.nl.uva.parser.elements.statements;

import java.util.List;

import main.nl.uva.parser.elements.errors.InvalidTypeError;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.type.Value;
import main.nl.uva.parser.elements.ui.IfUIElement;
import main.nl.uva.parser.elements.ui.UIElement;
import main.nl.uva.parser.elements.validation.ASTValidation;
import main.nl.uva.parser.elements.validation.Scope;

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
        String erg = "if ( " + _expression + " ) \n{ \n";
        for (Statement child : _children) {
            erg += child + "\n";
        }

        return erg + "} \n";
    }

    @Override
    public UIElement getLayout() {
        return new IfUIElement(_expression, _children);
    }
}
