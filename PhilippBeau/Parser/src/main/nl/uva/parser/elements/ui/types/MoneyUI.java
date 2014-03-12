package main.nl.uva.parser.elements.ui.types;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import main.nl.uva.parser.elements.ui.DeclarationUIElement;

public class MoneyUI extends ValueUI implements KeyListener {

    private final JTextField _textField;

    private final DeclarationUIElement _parent;

    public MoneyUI(final DeclarationUIElement parent) {
        _textField = new JTextField();
        _textField.addKeyListener(this);

        _parent = parent;
    }

    @Override
    public JComponent getComponent() {
        return _textField;
    }

    @Override
    public void keyTyped(final KeyEvent e) {}

    @Override
    public void keyPressed(final KeyEvent e) {}

    @Override
    public void keyReleased(final KeyEvent e) {
        double value = 0;

        try {
            value = Double.parseDouble(_textField.getText());
        } catch (NumberFormatException numberExceptino) {
            return;
        }

        _parent.onChange(value);
    }
}
