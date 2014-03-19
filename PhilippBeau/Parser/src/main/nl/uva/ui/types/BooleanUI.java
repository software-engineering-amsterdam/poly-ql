package main.nl.uva.ui.types;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import main.nl.uva.parser.element.type.Bool;
import main.nl.uva.parser.element.type.Value;
import main.nl.uva.ui.element.DeclarationUI;

public class BooleanUI extends ValueUI implements ItemListener {

    private final JCheckBox _checkBox;

    private final DeclarationUI _parent;

    public BooleanUI(final DeclarationUI parent, final Value value) {
        _checkBox = new JCheckBox();
        valueChange(value);

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
