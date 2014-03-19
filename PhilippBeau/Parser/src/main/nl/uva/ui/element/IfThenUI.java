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

        _ifPanel = generateBlockPanel(_expression, children, _parentUI);
        _ifPanel.setVisible(((Bool) expression.getValue()).getValue());
    }

    protected static JPanel generateBlockPanel(final Expression expression, final List<Statement> statements, final UI parent) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Statement child : statements) {
            panel.add(child.getLayout(parent).getPanel());
        }

        return panel;
    }

    @Override
    public JPanel getPanel() {
        return _ifPanel;
    }

    @Override
    public void onChange() {
        _ifPanel.setVisible(((Bool) _expression.getValue()).getValue());
    }

}
