package main.nl.uva.ui.element;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.nl.uva.parser.element.expression.Expression;
import main.nl.uva.parser.element.expression.ExpressionChangeListener;
import main.nl.uva.parser.element.statement.Statement;
import main.nl.uva.parser.element.type.Bool;
import main.nl.uva.ui.UI;

public class IfUI extends UIElement implements ExpressionChangeListener {

    private final JPanel _panel = new JPanel();

    private final Expression _expression;

    public IfUI(final Expression expression, final List<Statement> children, final UI parentUI) {
        super(parentUI);
        _expression = expression;
        _expression.registerListener(this);

        generateElement(children);
    }

    private void generateElement(final List<Statement> children) {
        _panel.setLayout(new BoxLayout(_panel, BoxLayout.Y_AXIS));

        for (Statement child : children) {
            _panel.add(child.getLayout(_parentUI).generateUIElement());
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
