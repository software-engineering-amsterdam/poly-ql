package main.nl.uva.ui.types;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.validation.type.Money;
import main.nl.uva.validation.type.Value;

public class MoneyUI extends ValueUI implements KeyListener {

    private final JTextField _textField;

    private final DeclarationUI _parent;

    public MoneyUI(final DeclarationUI parent, final Value value) {
        _textField = new JTextField();
        valueChange(value);
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
            _textField.setBackground(Color.RED);
            return;
        }

        _textField.setBackground(Color.WHITE);
        _parent.onChange(value);
    }

    @Override
    public void valueChange(final Value value) {
        Money money = (Money) value;
        _textField.setText(money.getValue() + "");
    }

    @Override
    public void setEditable(final boolean enabled) {
        _textField.setEditable(false);
    }
}
