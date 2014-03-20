package main.nl.uva.ui.element;

import java.util.List;

import javax.swing.JPanel;

import main.nl.uva.parser.Form;
import main.nl.uva.parser.statement.Statement;
import main.nl.uva.ui.UI;

public class FormUI extends UIElement {

    private final JPanel _panel;

    public FormUI(final Form form, final List<Statement> block, final UI parentUI) {
        super(parentUI);

        _panel = generateBlockPanel(block, parentUI);
    }

    @Override
    public JPanel getPanel() {
        return _panel;
    }
}
