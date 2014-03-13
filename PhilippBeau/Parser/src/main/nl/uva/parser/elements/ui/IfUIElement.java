package main.nl.uva.parser.elements.ui;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.nl.uva.parser.elements.expressions.Expression;
import main.nl.uva.parser.elements.expressions.ExpressionChangeListener;
import main.nl.uva.parser.elements.statements.Statement;
import main.nl.uva.parser.elements.type.Bool;

public class IfUIElement extends UIElement implements ExpressionChangeListener {

    private final JPanel _panel = new JPanel();

    private final Expression _expression;

    public IfUIElement(final Expression expression, final List<Statement> children) {
        _expression = expression;
        // _expression.register(this);

        generateElement(children);
    }

    private void generateElement(final List<Statement> children) {
        _panel.setLayout(new BoxLayout(_panel, BoxLayout.Y_AXIS));

        for (Statement child : children) {
            _panel.add(child.getLayout().generateUIElement());
        }

        _panel.setVisible(((Bool) _expression.getValue()).getValue());
    }

    @Override
    public JPanel generateUIElement() {
        return _panel;
    }

    @Override
    public void onChange() {
        _panel.setVisible(((Bool) _expression.getValue()).getValue());
    }

}
