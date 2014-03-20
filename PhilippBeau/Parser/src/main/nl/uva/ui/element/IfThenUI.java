package main.nl.uva.ui.element;

import java.util.List;

import javax.swing.JPanel;

import main.nl.uva.parser.expression.Expression;
import main.nl.uva.parser.expression.ExpressionChangeListener;
import main.nl.uva.parser.statement.Statement;
import main.nl.uva.ui.UI;
import main.nl.uva.validation.type.Bool;

public class IfThenUI extends UIElement implements ExpressionChangeListener {

    protected final JPanel _ifPanel;

    protected final Expression _expression;

    public IfThenUI(final Expression expression, final List<Statement> children, final UI parentUI) {
        super(parentUI);
        _expression = expression;
        _expression.registerListener(this);

        _ifPanel = generateBlockPanel(children, _parentUI);
        _ifPanel.setVisible(((Bool) expression.getValue()).getValue());
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
