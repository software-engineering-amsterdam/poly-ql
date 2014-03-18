package main.nl.uva.parser.elements.ui;

import javax.swing.JPanel;

import main.nl.uva.parser.elements.expressions.Variable;
import main.nl.uva.ui.UI;

public class ExpressionUIElement extends DeclarationUIElement {

    public ExpressionUIElement(final Variable variable, final String function, final UI parentUI) {
        super(variable, function, parentUI);
    }

    @Override
    public JPanel generateUIElement() {
        JPanel panel = super.generateUIElement();
        _valueUI.setEditable(false);

        return panel;
    }
}
