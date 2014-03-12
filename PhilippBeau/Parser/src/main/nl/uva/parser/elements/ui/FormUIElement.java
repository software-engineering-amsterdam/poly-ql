package main.nl.uva.parser.elements.ui;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.nl.uva.parser.elements.statements.Statement;

public class FormUIElement extends UIElement {

    private final List<Statement> _block;

    public FormUIElement(final List<Statement> block) {
        _block = block;
    }

    @Override
    public JPanel generateUIElement() {
        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));

        for (Statement child : _block) {
            layout.add(child.getLayout().generateUIElement());
        }

        return layout;
    }

}
