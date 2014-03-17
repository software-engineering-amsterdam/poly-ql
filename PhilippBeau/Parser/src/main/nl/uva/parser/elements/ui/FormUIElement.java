package main.nl.uva.parser.elements.ui;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.nl.uva.parser.elements.statements.ParserForm;
import main.nl.uva.parser.elements.statements.Statement;
import main.nl.uva.ui.UI;

public class FormUIElement extends UIElement {

    private final List<Statement> _block;

    public FormUIElement(final ParserForm form, final List<Statement> block, final UI parentUI) {
        super(parentUI);
        _block = block;
    }

    @Override
    public JPanel generateUIElement() {
        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));

        for (Statement child : _block) {
            layout.add(child.getLayout(_parentUI).generateUIElement());
        }

        return layout;
    }

}
