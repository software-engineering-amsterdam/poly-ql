package main.nl.uva.parser.elements.ui.types;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import main.nl.uva.parser.elements.ui.DeclarationUIElement;

public class BooleanUI extends ValueUI implements ItemListener {

    private final JCheckBox _checkBox;

    private final DeclarationUIElement _parent;

    public BooleanUI(final DeclarationUIElement parent) {
        _checkBox = new JCheckBox();
        _checkBox.addItemListener(this);

        _parent = parent;
    }

    @Override
    public void itemStateChanged(final ItemEvent e) {
        _parent.onChange(_checkBox.isSelected());
    }

    @Override
    public JComponent getComponent() {
        return _checkBox;
    }

}
