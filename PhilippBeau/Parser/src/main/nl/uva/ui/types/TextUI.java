package main.nl.uva.ui.types;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import main.nl.uva.ui.element.DeclarationUI;
import main.nl.uva.validation.type.Text;
import main.nl.uva.validation.type.Value;

public class TextUI extends ValueUI implements KeyListener {

    private final JTextField _textField;

    private final DeclarationUI _parent;

    public TextUI(final DeclarationUI parent, final Value value) {
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
        _parent.onChange(_textField.getText());
    }

    @Override
    public void valueChange(final Value value) {
        Text text = (Text) value;

        boolean isEditable = _textField.isEditable();

        _textField.setEditable(true);
        _textField.setText(text.getValue());
        _textField.setEditable(isEditable);
    }

    @Override
    public void setEditable(final boolean enabled) {
        _textField.setEditable(enabled);
    }
}
