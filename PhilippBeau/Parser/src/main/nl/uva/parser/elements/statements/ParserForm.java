package main.nl.uva.parser.elements.statements;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.nl.uva.parser.elements.ParserElement;
import main.nl.uva.parser.elements.errors.ValidationError;
import main.nl.uva.parser.elements.expressions.Variable;

public class ParserForm extends BlockStatement {

    private final List<Statement> _children;

    private final String _id;

    public ParserForm(final String id, final List<Statement> children) {

        _id = id;
        _children = children;

        setParentForChildren(_children);
    }

    @Override
    public String toString() {
        String erg = _id + "\n";

        for (Statement child : _children) {
            erg += child + "\n";
        }

        return erg;
    }

    @Override
    public Variable findVariable(final String variableName, final ParserElement scopeEnd) {
        return findVariableInChildren(_children, variableName, scopeEnd);
    }

    @Override
    public List<ValidationError> validate() {
        return validateStatements(_children);
    }

    @Override
    public JPanel getLayout() {
        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
        for (Statement child : _children) {
            layout.add(child.getLayout());
        }

        return layout;
    }
}
