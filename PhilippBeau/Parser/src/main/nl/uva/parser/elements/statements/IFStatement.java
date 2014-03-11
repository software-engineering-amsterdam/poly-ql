package main.nl.uva.parser.elements.statements;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.nl.uva.parser.elements.ParserElement;
import main.nl.uva.parser.elements.errors.InvalidTypeError;
import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.Variable;
import main.nl.uva.parser.elements.type.Bool;

public class IFStatement extends BlockStatement {

    protected final List<Statement> _children;

    private final Expression _expression;

    public IFStatement(final Expression expression, final List<Statement> children) {

        _expression = expression;
        _children = children;

        _expression.setParent(this);
        setParentForChildren(_children);
    }

    @Override
    public Variable findVariable(final String variableName, final ParserElement scopeEnd) {
        if (scopeEnd != _expression) {
            Variable result = findVariableInChildren(_children, variableName, scopeEnd);
            if (result != null) {
                return result;
            }
        }

        return _parent.findVariable(variableName, this);
    }

    @Override
    public List<ValidationError> validate() {
        List<ValidationError> expression = _expression.validate();

        if (!expression.isEmpty()) {
            return expression;
        }

        if (!(_expression.getType() instanceof Bool)) {
            expression.add(new InvalidTypeError(this.toString()));
            return expression;
        }

        return validateStatements(_children);
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
    public JPanel getLayout() {
        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
        for (Statement child : _children) {
            layout.add(child.getLayout());
        }

        layout.setVisible((Boolean) _expression.getResult());

        return layout;
    }
}
