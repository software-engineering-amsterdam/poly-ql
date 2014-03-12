package main.nl.uva.parser.elements.ui.types;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import main.nl.uva.parser.elements.ui.UIElement;

public class TextUI extends ValueUI implements ItemListener {

    private final JCheckBox _checkBox;

    public TextUI(final UIElement parent) {
        _checkBox = new JCheckBox();
        _checkBox.addItemListener(this);
    }

    @Override
    public void itemStateChanged(final ItemEvent e) {

    }

    @Override
    public JComponent getComponent() {
        return _checkBox;
    }

}
