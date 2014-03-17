package main.nl.uva.parser.elements.ui;

import javax.swing.JPanel;

import main.nl.uva.ui.UI;

public abstract class UIElement {

    protected final UI _parentUI;

    public UIElement(final UI parentUI) {
        _parentUI = parentUI;
    }

    protected void recalculateForm() {
        _parentUI.refreshView();
    }

    public abstract JPanel generateUIElement();
}
