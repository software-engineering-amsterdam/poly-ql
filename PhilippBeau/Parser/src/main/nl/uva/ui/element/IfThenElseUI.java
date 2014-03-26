package main.nl.uva.ui.element;

import java.util.List;

import javax.swing.JPanel;

import main.nl.uva.parser.expression.Expression;
import main.nl.uva.parser.statement.Statement;
import main.nl.uva.ui.UI;
import main.nl.uva.validation.type.Bool;

public class IfThenElseUI extends IfThenUI {

    private final JPanel _ifThenElsePanel;

    private final JPanel _elsePanel;

    public IfThenElseUI(final Expression expression, final List<Statement> ifStatements, final List<Statement> elseStatements,
            final UI parentUI) {
        super(expression, ifStatements, parentUI);

        _elsePanel = generateBlockPanel(elseStatements, _parentUI);
        _elsePanel.setVisible(!((Bool) expression.getValue()).getValue());

        _ifThenElsePanel = generateIfThenElsePanel(_ifPanel, _elsePanel);
    }

    private JPanel generateIfThenElsePanel(final JPanel ifPanel, final JPanel elsePanel) {
        JPanel parent = generateYAxisPanel();

        parent.add(ifPanel);
        parent.add(elsePanel);

        return parent;
    }

    @Override
    public JPanel getPanel() {
        return _ifThenElsePanel;
    }

    @Override
    public void onChange() {
        boolean ifExpressionValue = ((Bool) _expression.getValue()).getValue();

        _ifPanel.setVisible(ifExpressionValue);
        _elsePanel.setVisible(!ifExpressionValue);
    }

}
