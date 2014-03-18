package main.nl.uva.parser.elements.ui.types;

import javax.swing.JComponent;

import main.nl.uva.parser.elements.type.Value;

public abstract class ValueUI {

    public abstract JComponent getComponent();

    public abstract void valueChange(Value value);

    public abstract void setEditable(boolean enabled);

}
