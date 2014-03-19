package main.nl.uva.ui.element;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.nl.uva.parser.element.expression.Expression;
import main.nl.uva.parser.element.expression.ExpressionChangeListener;
import main.nl.uva.parser.element.statement.Statement;
import main.nl.uva.parser.element.type.Bool;
import main.nl.uva.ui.UI;

public class IfThenUI extends UIElement implements ExpressionChangeListener {

    protected final JPanel _ifPanel;

    protected final Expression _expression;

    public IfThenUI(final Expression expression, final List<Statement> children, final UI parentUI) {
        super(parentUI);
        _expression = expression;
        _expression.registerListener(this);

        _ifPanel = generateBlockPanel(_expression, children);
        _ifPanel.setVisible(((Bool) expression.getValue()).getValue());
    }

    protected JPanel generateBlockPanel(final Expression expression, final List<Statement> statements) {
        JPanel parent = new JPanel();
        parent.setLayout(new BoxLayout(parent, BoxLayout.Y_AXIS));

        for (Statement child : statements) {
            parent.add(child.getLayout(_parentUI).generateUIElement());
        }

        return parent;
    }

    @Override
    public JPanel generateUIElement() {
        return _ifPanel;
    }

    @Override
    public void onChange() {
        _ifPanel.setVisible(((Bool) _expression.getValue()).getValue());
    }

}
