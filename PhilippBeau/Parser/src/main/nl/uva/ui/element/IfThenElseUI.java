package main.nl.uva.ui.element;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.nl.uva.parser.element.expression.Expression;
import main.nl.uva.parser.element.statement.Statement;
import main.nl.uva.ui.UI;
import main.nl.uva.validation.type.Bool;

public class IfThenElseUI extends IfThenUI {

    private final JPanel _ifThenElsePanel;

    private final JPanel _elsePanel;

    public IfThenElseUI(final Expression expression, final List<Statement> ifStatements, final List<Statement> elseStatements,
            final UI parentUI) {
        super(expression, ifStatements, parentUI);

        _elsePanel = generateBlockPanel(expression, elseStatements, _parentUI);
        _elsePanel.setVisible(!((Bool) expression.getValue()).getValue());

        _ifThenElsePanel = generateIfThenElsePanel(_ifPanel, _elsePanel);
    }

    private static JPanel generateIfThenElsePanel(final JPanel ifPanel, final JPanel elsePanel) {
        JPanel parent = new JPanel();
        parent.setLayout(new BoxLayout(parent, BoxLayout.Y_AXIS));
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
