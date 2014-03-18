package main.nl.uva.parser.elements.ui.types;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import main.nl.uva.parser.elements.type.Bool;
import main.nl.uva.parser.elements.type.Value;
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

    public void setValue(final boolean value) {
        _checkBox.setSelected(value);
    }

    @Override
    public JComponent getComponent() {
        return _checkBox;
    }

    @Override
    public void valueChange(final Value value) {
        Bool bool = (Bool) value;
        _checkBox.setSelected(bool.getValue());
    }

    @Override
    public void setEditable(final boolean enabled) {
        _checkBox.setEnabled(enabled);
    }

}
